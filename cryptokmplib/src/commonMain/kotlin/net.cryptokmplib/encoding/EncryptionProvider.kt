package net.cryptokmplib.encoding

import com.ionspin.kotlin.crypto.LibsodiumInitializer
import com.ionspin.kotlin.crypto.LibsodiumInitializer.isInitialized
import com.ionspin.kotlin.crypto.signature.Signature

class EncryptionProvider {

    // A library needs to be initialized first before it can be used for any other operation
    suspend fun initSodiumLibrary(): Boolean {
        LibsodiumInitializer.initialize()
        return isInitialized()
    }

    /// Generates ed25519 key pair (private & public key) using Sodium KMP library
    /// - Parameters:
    ///     - encoding: how the keys should be encoded (base64, base58, etc...)
    /// - Returns: generated keypair with encoding specified in the input parameter
    /// - Throws: CryptoError if any error related to Cryptography happens. See CryptoError for more details
    @OptIn(ExperimentalUnsignedTypes::class)
    suspend fun generateEd25519KeyPair(encoding: Encoding = Encoding.NONE): KeyPair {
        if (isInitialized().not()) {
            LibsodiumInitializer.initialize()
        }
        val ed25519KeyPair = Signature.keypair()

        val privateKeyData = ed25519KeyPair.secretKey
        val publicKeyData = ed25519KeyPair.publicKey

        return when(encoding) {
            Encoding.BASE64 -> {
                KeyPair(
                    Base64Encoder.encodeToString(privateKeyData.toByteArray()),
                    Base64Encoder.encodeToString(publicKeyData.toByteArray())
                )
            }
            Encoding.BASE58 -> {
                KeyPair(
                    privateKeyData.toByteArray().encodeToBase58(),
                    publicKeyData.toByteArray().encodeToBase58()
                )
            }
            Encoding.NONE -> {
                KeyPair(
                    privateKey = privateKeyData.toByteArray().decodeToString(),
                    publicKey = publicKeyData.toByteArray().decodeToString()
                )
            }
        }
    }
}