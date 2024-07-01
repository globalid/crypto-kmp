// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = "1.0.2"
let checksum = "8c0d92f4c3f9fa0afd7e2e1f96a5a46e5b319130f224d5863daadaa44d6a5b66"
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
