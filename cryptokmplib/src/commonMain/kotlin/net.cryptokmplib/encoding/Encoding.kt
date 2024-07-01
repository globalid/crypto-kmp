@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package net.cryptokmplib.encoding

enum class Encoding {
    BASE64,
    BASE58,
    NONE,
}

expect object Base64Encoder {
    fun encodeToString(bytes: ByteArray): String
    fun decodeFromString(encodedString: String): ByteArray
}

expect fun String.toUtf8ByteArray(): ByteArray