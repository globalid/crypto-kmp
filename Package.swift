// swift-tools-version: 5.6
import PackageDescription

// Tag is required to point towards the right asset. SPM requires the tag to follow semantic versioning to be able to resolve it.
let name = "cryptoKMP"
let tag = "v0.0.1.33"
let checksum = "f597c45efc646a10d3ca4f778e88f2387ffd5154493a165a659b6acd8350ba45"
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
