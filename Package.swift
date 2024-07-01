// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = "1.0.1"
let checksum = "591fe31f2858a56dfadd5906c2e2626aa9516418c421a347b4b707f7758450c0"
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
