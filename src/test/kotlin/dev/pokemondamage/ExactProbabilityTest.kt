package dev.pokemondamage

import dev.pokemondamage.model.ExactProbability
import java.math.BigInteger
import kotlin.test.*

class ExactProbabilityTest {
    private val one = BigInteger.ONE
    private val zero = BigInteger.ZERO

    @Test
    fun `probability validates bounds and distinguishes certain from impossible`() {
        assertEquals(0.0, ExactProbability(zero, one).probability)
        assertFalse(ExactProbability(zero, one).guaranteed)
        assertEquals(1.0, ExactProbability(one, one).probability)
        assertTrue(ExactProbability(one, one).guaranteed)
        assertFailsWith<IllegalArgumentException> { ExactProbability(one, zero) }
        assertFailsWith<IllegalArgumentException> { ExactProbability(zero, -one) }
        assertFailsWith<IllegalArgumentException> { ExactProbability(-one, one) }
        assertFailsWith<IllegalArgumentException> { ExactProbability(one + one, one) }
    }

    @Test
    fun `huge integers produce finite correctly rounded probabilities`() {
        val huge = one.shiftLeft(2000)
        assertEquals(1.0 / 3, ExactProbability(huge, huge * BigInteger.valueOf(3)).probability)
        assertEquals(0.5, ExactProbability(huge, huge.shiftLeft(1)).probability)
        assertEquals(
            0.75,
            ExactProbability(BigInteger.valueOf(3), BigInteger.valueOf(4)).probability,
        )
    }

    @Test
    fun `subnormal probabilities are rounded to nearest with ties to even`() {
        assertEquals(Double.MIN_VALUE, ExactProbability(one, one.shiftLeft(1074)).probability)
        assertEquals(0.0, ExactProbability(one, one.shiftLeft(1075)).probability)
        assertEquals(
            2 * Double.MIN_VALUE,
            ExactProbability(BigInteger.valueOf(3), one.shiftLeft(1075)).probability,
        )
        assertEquals(0.0, ExactProbability(one, one.shiftLeft(3000)).probability)
        assertEquals(
            Double.MIN_VALUE,
            ExactProbability(BigInteger.valueOf(3), one.shiftLeft(1076)).probability,
        )
    }

    @Test
    fun `normal halfway values round to the even significand`() {
        val denominator = one.shiftLeft(54)
        assertEquals(0.5, ExactProbability(one.shiftLeft(53) + one, denominator).probability)
        assertEquals(
            Math.nextUp(Math.nextUp(0.5)),
            ExactProbability(one.shiftLeft(53) + BigInteger.valueOf(3), denominator).probability,
        )
    }
}
