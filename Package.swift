// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = "v0.0.1"
let checksum = "86a9a29529f7e19b02c6432771739b356caf06854ca3d9988fbed3ea4ae7e1f7"
let url = "https://github.com/globalid/crypto-kmp/archive/refs/tags/\(tag)/.zip"


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
                 checksum: checksum),
  ]
)
