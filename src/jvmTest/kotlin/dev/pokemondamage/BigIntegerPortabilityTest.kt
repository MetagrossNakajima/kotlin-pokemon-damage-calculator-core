package dev.pokemondamage

import dev.pokemondamage.math.BigInteger
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals
import java.math.BigInteger as JvmInteger

class BigIntegerPortabilityTest {
    @Test
    fun `exact arithmetic agrees with JVM for signed and large weights`() {
        val random = Random(716)
        val values =
            listOf("0", "1", "-1", "2147483647", "-2147483648") +
                List(32) { JvmInteger(1, random.nextBytes(64)).toString() }
        for (left in values) {
            for (right in listOf("1", "-3", "18446744073709551617")) {
                val a = BigInteger(left)
                val b = BigInteger(right)
                val ja = JvmInteger(left)
                val jb = JvmInteger(right)
                assertEquals((ja + jb).toString(), (a + b).toString())
                assertEquals((ja - jb).toString(), (a - b).toString())
                assertEquals((ja * jb).toString(), (a * b).toString())
                assertEquals((ja / jb).toString(), (a / b).toString())
                assertEquals((ja % jb).toString(), (a % b).toString())
                assertEquals(ja.gcd(jb).toString(), a.gcd(b).toString())
                val (q, r) = a.divideAndRemainder(b)
                assertEquals((ja / jb).toString(), q.toString())
                assertEquals((ja % jb).toString(), r.toString())
                assertEquals(ja.signum(), a.signum())
                assertEquals(ja.compareTo(jb), a.compareTo(b))
                assertEquals(ja.min(jb).toString(), a.min(b).toString())
                assertEquals(ja.max(jb).toString(), a.max(b).toString())
            }
        }
    }

    @Test
    fun `probability bit operations agree across machine word boundaries`() {
        for (bit in listOf(0, 31, 32, 63, 64, 127, 1022, 1074, 2000)) {
            val jvm = JvmInteger.ONE.shiftLeft(bit) + JvmInteger.ONE
            val common = BigInteger.ONE.shiftLeft(bit) + BigInteger.ONE
            assertEquals(jvm.toString(), common.toString())
            assertEquals(jvm.bitLength(), common.bitLength())
            assertEquals(jvm.testBit(0), common.testBit(0))
            assertEquals(jvm.testBit(bit), common.testBit(bit))
            assertEquals(jvm.testBit(bit + 2), common.testBit(bit + 2))
        }
        assertEquals(BigInteger.ONE, BigInteger.ZERO.pow(0))
        assertEquals("59049", BigInteger.valueOf(3).pow(10).toString())
    }

    @Test
    fun `checked conversions reject overflow and equality supports distribution keys`() {
        assertEquals(Int.MAX_VALUE, BigInteger("2147483647").intValueExact())
        assertEquals(Int.MIN_VALUE, BigInteger("-2147483648").intValueExact())
        assertFailsWith<ArithmeticException> { BigInteger("2147483648").intValueExact() }
        assertFailsWith<ArithmeticException> { BigInteger("-2147483649").intValueExact() }
        assertFailsWith<ArithmeticException> { BigInteger.ONE / BigInteger.ZERO }
        assertEquals(Long.MAX_VALUE, BigInteger.valueOf(Long.MAX_VALUE).toLong())
        assertEquals(1.5, BigInteger.valueOf(3).toDouble() / 2)
        assertEquals(BigInteger("2"), BigInteger.TWO)
        assertEquals(BigInteger("2").hashCode(), BigInteger.TWO.hashCode())
        assertNotEquals(BigInteger.ZERO, BigInteger.ONE)
        assertNotEquals<Any?>(BigInteger.ZERO, null)
        assertNotEquals<Any>(BigInteger.ZERO, "0")
    }
}
