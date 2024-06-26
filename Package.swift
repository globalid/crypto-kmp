// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = v0.0.1.28
let checksum = 6ecfb6d550c9f0bfd8af5b7cc7467a914ab687aec7abfd3b8ecd645302ccc2a6
let url = "https://github.com/globalid/crypto-kmp/releases/download/\(tag)/cryptokmplib.zip"


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
