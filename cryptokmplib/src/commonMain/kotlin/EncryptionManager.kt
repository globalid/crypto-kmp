import com.ionspin.kotlin.crypto.LibsodiumInitializer
import com.ionspin.kotlin.crypto.LibsodiumInitializer.isInitialized
import com.ionspin.kotlin.crypto.signature.Signature
import encoding.Base64Encoder
import encoding.Encoding
import encoding.encodeToBase58

class EncryptionManager {

    // A library needs to be initialized first before it can be used for any other operation
    suspend fun initSodiumLibrary(): Boolean {
        LibsodiumInitializer.initialize()
        return isInitialized()
    }

    /// Generates ed25519 key pair (private & public key) using Sodium library
    /// - Parameters:
    ///     - encoding: how the keys should be encoded (base64, base58, etc...)
    /// - Returns: generated keypair with encoding specified in the input parameter
    /// - Throws: CryptoError if any error related to Cryptography happens. See CryptoError for more details
    @OptIn(ExperimentalUnsignedTypes::class)
    suspend fun generateEd25519KeyPair(encoding: Encoding): KeyPair {
        LibsodiumInitializer.initialize()
        val ed25519KeyPair = Signature.keypair()

        val privateKeyData = ed25519KeyPair.secretKey
        val publicKeyData = ed25519KeyPair.publicKey

        return when(encoding) {
            Encoding.BASE64 -> {
                KeyPair(
                    Base64Encoder.encodeToString(publicKeyData.toByteArray()),
                    Base64Encoder.encodeToString(privateKeyData.toByteArray()),
                )
            }
            Encoding.Base58 -> {
                KeyPair(
                    publicKeyData.toByteArray().encodeToBase58(),
                    privateKeyData.toByteArray().encodeToBase58(),
                )
            }
        }
    }
}