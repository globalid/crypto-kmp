import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinComposeCompiler)
    alias(libs.plugins.skie)
    id("module.publication")
}

kotlin {
    jvm()
    jvmToolchain(17)
    androidTarget {
        publishLibraryVariants("release")
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    val xcFramework = XCFramework()
    val iosTargets = listOf(iosX64(), iosArm64(), iosSimulatorArm64())

    iosTargets.forEach {
        it.binaries.framework {
            baseName = "cryptokmplib"
            xcFramework.add(this)
            binaryOption("bundleId", "net.globalid.cryptokmplib")
            binaryOption("bundleVersion", "0.0.1")
        }
    }

    targets.all {
        compilations.all {
            compileTaskProvider.configure{
                compilerOptions {
                    allWarningsAsErrors.set(true)
                }
            }
        }
    }
    jvm().compilations.all {
        compileTaskProvider.configure{
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_17)
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.sodium)
                implementation(libs.composeRuntime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.junit)
            }
        }
        val iosTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
    task("testClasses")
    task("linuxX64MainBinaries")
    task("linuxX64TestBinaries")
    task("linkLinuxX64")
}

android {
    namespace = "net.globalid.cryptokmplib"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
