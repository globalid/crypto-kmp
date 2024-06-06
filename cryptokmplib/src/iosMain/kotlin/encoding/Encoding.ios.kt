@file:OptIn(ExperimentalForeignApi::class)
@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package encoding

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.base64EncodedStringWithOptions
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding

@ExperimentalForeignApi
actual object Base64Encoder {
    actual fun encodeToString(bytes: ByteArray): String {
        val data = bytes.toNSData()
        return data.base64EncodedStringWithOptions(0u)
    }

    @OptIn(BetaInteropApi::class)
    actual fun decodeFromString(encodedString: String): ByteArray {
        val data = NSData.create(base64EncodedString = encodedString, options = 0u)
        return data?.toByteArray() ?: ByteArray(0)
    }
}

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
actual fun String.toUtf8ByteArray(): ByteArray {
    val nsString = NSString.create(string = this)
    val data = nsString.dataUsingEncoding(NSUTF8StringEncoding)!!
    val bytes = ByteArray(data.length.toInt())
    bytes.usePinned {
        platform.posix.memcpy(it.addressOf(0), data.bytes, data.length)
    }
    return bytes
}


