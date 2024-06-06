@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package encoding

enum class Encoding {
    BASE64,
    Base58,
}

expect object Base64Encoder {
    fun encodeToString(bytes: ByteArray): String
    fun decodeFromString(encodedString: String): ByteArray
}

expect fun String.toUtf8ByteArray(): ByteArray