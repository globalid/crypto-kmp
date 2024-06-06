@file:OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)

package encoding

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.usePinned
import platform.Foundation.NSString
import platform.Foundation.create

actual fun constructString(chars: CharArray, offset: Int, length: Int): String {
    val byteArray = ByteArray(length) // convert CharArray to ByteArray
    for (i in 0 until length) {
        byteArray[i] = chars[offset + i].code.toByte()
    }
    return byteArray.usePinned {
        val nsString = NSString.create(
            bytes = it.addressOf(0),
            length = length.convert(),
            encoding = platform.Foundation.NSUTF8StringEncoding
        )
        nsString.toString()
    }
}