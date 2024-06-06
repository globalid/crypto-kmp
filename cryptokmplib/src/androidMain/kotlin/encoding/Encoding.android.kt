@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package encoding

import java.util.Base64

// CommonMain
actual object Base64Encoder {
    actual fun encodeToString(bytes: ByteArray): String {
        return Base64.getEncoder().encodeToString(bytes)
    }

    actual fun decodeFromString(encodedString: String): ByteArray {
        return Base64.getDecoder().decode(encodedString)
    }
}

actual fun String.toUtf8ByteArray(): ByteArray {
    return this.toByteArray(charset("utf-8"))
}