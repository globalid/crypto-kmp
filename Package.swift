// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "cryptoKMPKit",
    platforms: [
        .iOS(.v16)
    ],
    products: [
        .library(
            name: "cryptoKMPKit",
            targets: ["cryptoKMPKit"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "cryptoKMPKit",
            path: "./cryptoKMPKit.xcframework"
        ),
    ]
)
