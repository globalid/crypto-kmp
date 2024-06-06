package encoding

private const val ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
private val BASE58 = ALPHABET.toCharArray()
private val INDEXES = IntArray(128) { -1 }.apply {
    for (i in BASE58.indices) {
        this[BASE58[i].code] = i
    }
}

fun ByteArray.encodeToBase58(): String {
    if (isEmpty()) return ""

    var zeros = 0
    while (zeros < size && this[zeros] == 0.toByte()) {
        ++zeros
    }

    val input = this.copyOf(size) // since we modify it in-place
    val encoded = CharArray(size * 2) // upper bound
    var outputStart = encoded.size
    var inputStart = zeros
    while (inputStart < input.size) {
        encoded[--outputStart] = BASE58[divmod(input, inputStart, 256, 58).toInt()]
        if (input[inputStart] == 0.toByte()) {
            ++inputStart // optimization - skip leading zeros
        }
    }

    // Preserve exactly as many leading encoded zeros in output as there were leading zeros in input.
    while (outputStart < encoded.size && encoded[outputStart] == BASE58[0]) {
        ++outputStart
    }
    while (--zeros >= 0) {
        encoded[--outputStart] = BASE58[0]
    }

    return constructString(encoded, outputStart, encoded.size - outputStart)
}

fun String.decodeFromBase58(): ByteArray {
    if (isEmpty()) return ByteArray(0)

    // Convert the base58-encoded ASCII chars to a base58 byte sequence (base58 digits).
    val input58 = ByteArray(length)
    for (i in indices) {
        val c = this[i]
        val digit = if (c.code < 128) INDEXES[c.code] else -1
        require(digit >= 0) { "Invalid Base58 character: $c" }
        input58[i] = digit.toByte()
    }

    // Count leading zeros.
    var zeros = 0
    while (zeros < input58.size && input58[zeros] == 0.toByte()) {
        ++zeros
    }

    // Convert base-58 digits to base-256 digits.
    val decoded = ByteArray(length)
    var outputStart = decoded.size
    var inputStart = zeros
    while (inputStart < input58.size) {
        decoded[--outputStart] = divmod(input58, inputStart, 58, 256)
        if (input58[inputStart] == 0.toByte()) {
            ++inputStart // optimization - skip leading zeros
        }
    }

    // Ignore extra leading zeros that were added during the calculation.
    while (outputStart < decoded.size && decoded[outputStart] == 0.toByte()) {
        ++outputStart
    }

    return decoded.copyOfRange(outputStart - zeros, decoded.size)
}

private fun divmod(number: ByteArray, firstDigit: Int, base: Int, divisor: Int): Byte {
    var remainder = 0
    for (i in firstDigit until number.size) {
        val digit = number[i].toInt() and 0xFF
        val temp = remainder * base + digit
        number[i] = (temp / divisor).toByte()
        remainder = temp % divisor
    }
    return remainder.toByte()
}