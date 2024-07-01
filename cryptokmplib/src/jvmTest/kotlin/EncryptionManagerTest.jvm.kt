import cafe.cryptography.curve25519.CompressedEdwardsY
import encoding.Encoding
import encoding.decodeFromBase58
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertFails

class EncryptionManagerTest {
    fun isValid(publicKey: String): Boolean {
        try {
            val bytes: ByteArray = publicKey.decodeFromBase58()
            if (bytes.size != 32) {
                assertFails { "Key lenght must be 32 bytes" }
                return false
            }
            return !CompressedEdwardsY(bytes).decompress().isSmallOrder()
        } catch (e: Exception) {
            assertFails { "Invalid public key" }
            return false
        }
    }

    @Test
    fun testKeyGeneration() {
        val publicKey = runBlocking {
            EncryptionManager().generateEd25519KeyPair(Encoding.Base58).publicKey
        }
        assert(isValid(publicKey))
    }


}