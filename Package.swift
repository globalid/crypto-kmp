// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = "1.0.0"
let checksum = "015103347383a8232a229420da1aeef84a313143a39029e93a2367568d255959"
let url = "https://github.com/globalid/crypto-kmp/releases/download/\(tag)/cryptokmplib.zip"


let package = Package(
  name: name,
  platforms: [.iOS(.v14)],
  products: [
    .library(
      name: name,
      targets: [name]
    ),
  ],
  dependencies: [],
  targets: [
   .binaryTarget(name: name,
                 url: url,
                 checksum: checksum)
  ]
)
