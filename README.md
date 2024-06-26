<h1 align="center">
  <br>
  Crypto Kotlin multiplatform
  <br>
</h1>

<h4 align="center">Crypto Kotlin multiplatform project addresses cryptography utils and functions we use inside GlobaliD ecosystem. </h4>

<p align="center">
  [Project's badges]
</p>

<p align="center">
  <a href="#about">About</a> •
  <a href="#key-features">Key Features</a> •
  <a href="#getting-started">Getting Started</a> •
  <a href="#faq">FAQ</a> •
  <a href="#roadmap">Roadmap</a> •
  <a href="#support">Support</a> •
  <a href="#license">License</a>
</p>

## About

This is a Kotlin multiplatform project provides encryption utilities for Android, iOS, and JVM. It is based on the sodium encryption library.

## Key Features

- ED25519 Basic cryptography (Eliptic curve)
  - Encrypt functions
  - Decrypt functions
  - generate keys functions
- AES 256/512 data encryptopn
  - Encrypt functions
  - Decrypt functions
- Base64/Base58 and Base58/Base64 converter

## Getting Started

To use this library, developer must set up a few things.

### Prerequisites

To work with library, developer must first install tools we need to build Kotlin project: 

- JDK 17 -> <a href="https://medium.com/java-mvp/install-openjdk-17-on-macos-c0ddb3ac9f0e">https://medium.com/java-mvp/install-openjdk-17-on-macos-c0ddb3ac9f0e</a>
- Kotlin -> <a href="https://kotlinlang.org/docs/command-line.html">https://kotlinlang.org/docs/command-line.html</a>
- Gradle -> <a href="https://gradle.org/install/">https://gradle.org/install/</a>

### Installing and Running (Library)

### Installing and Running (iOS - SPM)

Kotlin library is built (with "Deploy iOS" Github action) as an xCode framework, when new version of library will be merged to main. 

Library must be addet to iOS project via Swift Package Manager.

The [Swift Package Manager](https://swift.org/package-manager/) is a tool for automating the distribution of Swift code and is integrated into the `swift` compiler.

Once you have your Swift package set up, adding cryptoKMP as a dependency is as easy as adding it to the `dependencies` value of your `Package.swift` or the Package list in Xcode.

```swift
dependencies: [
    .package(url: "https://github.com/globalid/crypto-kmp", .branch("master"))
]
```

After successfull add, library is accessed via standard swift import

```swift
import cryptokmplib

private let manager = EncryptionManager()
```

## FAQ

### Is it any good?

It will be

## Definitions



## Roadmap

- [x] Add this README.
- [ ] Finish the crypto KMP project


## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the project
2. Clone it open the repository in command line
3. Create your feature branch (`git checkout -b feature/amazing-feature`)
4. Commit your changes (`git commit -m 'Add some amazing feature'`)
5. Push to the branch (`git push origin feature/amazing-feature`)
6. Open a pull request from your feature branch from your repository into this repository main branch, and provide a description of your changes

## License



## Acknowledgments

Copyright 2024 @ GlobaliD