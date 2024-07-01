package net.cryptokmplib
import net.cryptokmplib.encoding.decodeFromBase58
import net.cryptokmplib.encoding.encodeToBase58
import net.cryptokmplib.encoding.toUtf8ByteArray
import kotlin.test.Test
import kotlin.test.assertEquals

class Base58EncodingTest {

    @Test
    fun testBase58Encoding() {
        val input = "Hello, World!".toUtf8ByteArray()
        val expected = "72k1xXWG59fYdzSNoA"
        val actual = input.encodeToBase58()
        assertEquals(expected, actual)
    }

    @Test
    fun testBase58EncodingLeadingZeros() {
        val input = byteArrayOf(0, 0, 0, 1)
        val expected = "1112"
        val actual = input.encodeToBase58()
        assertEquals(expected, actual)
    }

    @Test
    fun testBase58EncodingEmpty() {
        val input = byteArrayOf()
        val expected = ""
        val actual = input.encodeToBase58()
        assertEquals(expected, actual)
    }

    @Test
    fun testBase58Decoding() {
        val input = "JxF12TrwUP45BMd"
        val expected = "Hello World".toUtf8ByteArray().toList()
        val actual = input.decodeFromBase58().toList()
        assertEquals(expected, actual)
    }

    @Test
    fun testBase58DecodingLeadingZeros() {
        val input = "1112"
        val expected = byteArrayOf(0, 0, 0, 1).toList()
        val actual = input.decodeFromBase58().toList()
        assertEquals(expected, actual)
    }

    @Test
    fun testBase58DecodingEmpty() {
        val input = ""
        val expected = byteArrayOf().toList()
        val actual = input.decodeFromBase58().toList()
        assertEquals(expected, actual)
    }
}