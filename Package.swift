// swift-tools-version: 5.6
import PackageDescription

let package = Package(
  name: "cryptoKMP",
  platforms: [.iOS(.v14)],
  products: [
    .library(
      name: "cryptoKMP",
      targets: ["cryptoKMP"]
    ),
  ],
  dependencies: [],
  targets: [
    .binaryTarget(name: "cryptoKMP",
            path: "./distribution/cryptokmplib.xcframework"),
  ]
)
