package encoding

actual fun constructString(chars: CharArray, offset: Int, length: Int): String {
    return String(chars, offset, length)
}