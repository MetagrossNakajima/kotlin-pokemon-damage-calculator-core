package dev.pokemondamage.math

import com.ionspin.kotlin.bignum.integer.BigInteger as ArbitraryInteger

/** Platform-independent exact integers for damage distributions and probability weights. */
class BigInteger private constructor(
    private val value: ArbitraryInteger,
) : Comparable<BigInteger> {
    constructor(decimal: String) : this(ArbitraryInteger.parseString(decimal, 10))

    override fun compareTo(other: BigInteger): Int = value.compareTo(other.value)

    operator fun plus(other: BigInteger): BigInteger = BigInteger(value + other.value)

    operator fun minus(other: BigInteger): BigInteger = BigInteger(value - other.value)

    operator fun times(other: BigInteger): BigInteger = BigInteger(value * other.value)

    operator fun div(other: BigInteger): BigInteger = BigInteger(value / other.value)

    operator fun rem(other: BigInteger): BigInteger =
        BigInteger(value.divideAndRemainder(other.value).second)

    operator fun unaryMinus(): BigInteger = BigInteger(-value)

    fun add(other: BigInteger): BigInteger = this + other

    fun signum(): Int = value.signum()

    fun bitLength(): Int = value.bitLength()

    fun shiftLeft(bits: Int): BigInteger = BigInteger(value shl bits)

    fun testBit(bit: Int): Boolean = value.bitAt(bit.toLong())

    // The empty product is one, including 0^0 in hit-count probability products.
    fun pow(exponent: Int): BigInteger = if (exponent == 0) ONE else BigInteger(value.pow(exponent))

    fun gcd(other: BigInteger): BigInteger = BigInteger(value.gcd(other.value))

    fun min(other: BigInteger): BigInteger = minOf(this, other)

    fun max(other: BigInteger): BigInteger = maxOf(this, other)

    fun toInt(): Int = value.intValue(false)

    fun toLong(): Long = value.longValue(false)

    fun intValueExact(): Int = value.intValue(true)

    fun toDouble(): Double = value.doubleValue(false)

    fun divideAndRemainder(other: BigInteger): Pair<BigInteger, BigInteger> {
        val (quotient, remainder) = value.divideAndRemainder(other.value)
        return BigInteger(quotient) to BigInteger(remainder)
    }

    override fun equals(other: Any?): Boolean = other is BigInteger && value == other.value

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = value.toString()

    companion object {
        val ZERO: BigInteger = BigInteger(ArbitraryInteger.ZERO)
        val ONE: BigInteger = BigInteger(ArbitraryInteger.ONE)
        val TWO: BigInteger = valueOf(2)

        fun valueOf(value: Long): BigInteger = BigInteger(ArbitraryInteger.fromLong(value))
    }
}

fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)
