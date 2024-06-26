// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = v0.0.1.27
let checksum = e4c91b00f372f7b43e08c851ff518e22268cb581b122c140b0aba092115c172e
let url = "https://github.com/globalid/crypto-kmp/archive/refs/tags/\(tag).zip"


let package = Package(
  name: name,
  platforms: [.iOS(.v14)],
  products: [
    .library(
      name: name targets: [name]
    ),
  ],
  dependencies: [],
  targets: [
   .binaryTarget(name: name,
                 url: url,
                 checksum: checksum),
  ]
)
