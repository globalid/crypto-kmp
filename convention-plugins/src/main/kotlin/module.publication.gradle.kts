import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications {
        withType<MavenPublication> {
            groupId = "global"
            artifactId = "cryptokmplib"
            version = "0.0.3" // TODO: Find a way to automate this.

            pom {
                name.set("Crypto KMP Lib")
                description.set("A multiplatform library that includes global id encryption functionality.")
            }
        }

        create<MavenPublication>("jvmPublication") {
            from(components["kotlin"])
            artifactId = "cryptokmplib"
        }
    }
    
    repositories {
        maven {
            credentials {
                username = findProperty("globalidMavenUsername") as String?
                password = findProperty("globalidMavenPassword") as String?
            }
            url = uri("https://repository.tools.global.id/repository/maven-internal/id/")
        }
    }
}
