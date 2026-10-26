package dev.pokemondamage

import dev.pokemondamage.model.DamageDistribution
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DamageDistributionTest {
    private fun n(value: Long) = BigInteger.valueOf(value)

    @Test
    fun `duplicate rolls retain exact multiplicity and sorted extrema`() {
        val distribution = DamageDistribution.fromRolls(listOf(23, 19, 20, 20, 19))
        assertEquals(mapOf(n(19) to n(2), n(20) to n(2), n(23) to n(1)), distribution.weights)
        assertEquals(n(5), distribution.totalWeight)
        assertEquals(n(19), distribution.min)
        assertEquals(n(23), distribution.max)
        assertEquals(n(3), distribution.knockoutProbability(n(20)).weight)
        assertEquals(n(5), distribution.knockoutProbability(n(20)).totalWeight)
        assertEquals(0.6, distribution.knockoutProbability(n(20)).probability)
        assertTrue(distribution.knockoutProbability(n(0)).guaranteed)
        assertEquals(0.0, distribution.knockoutProbability(n(24)).probability)
        assertFailsWith<IllegalArgumentException> { distribution.knockoutProbability(n(-1)) }
    }

    @Test
    fun `inputs and exposed maps cannot mutate the distribution`() {
        val input = mutableMapOf(n(9) to n(2))
        val distribution = DamageDistribution(input)
        input.clear()
        assertEquals(mapOf(n(9) to n(2)), distribution.weights)
        assertFailsWith<UnsupportedOperationException> {
            (distribution.weights as MutableMap)[n(10)] = n(1)
        }
        assertEquals(n(2), distribution.totalWeight)
    }

    @Test
    fun `damage and weights exceed machine integer limits without loss`() {
        val huge = BigInteger.ONE.shiftLeft(2000)
        val distribution = DamageDistribution(mapOf(huge to huge, huge + n(1) to huge))
        assertEquals(huge, distribution.min)
        assertEquals(huge + n(1), distribution.max)
        assertEquals(huge * n(2), distribution.totalWeight)
        assertEquals(0.5, distribution.knockoutProbability(huge + n(1)).probability)
    }

    @Test
    fun `invalid distributions fail at construction`() {
        assertFailsWith<IllegalArgumentException> { DamageDistribution(emptyMap()) }
        assertFailsWith<IllegalArgumentException> { DamageDistribution.fromRolls(emptyList()) }
        assertFailsWith<IllegalArgumentException> { DamageDistribution.fromRolls(listOf(-1)) }
        for (weight in listOf(0L, -1L)) {
            assertFailsWith<IllegalArgumentException> {
                DamageDistribution(mapOf(n(1) to n(weight)))
            }
        }
    }

    @Test
    fun `distribution equality compares values independent of input order`() {
        val first = DamageDistribution.fromRolls(listOf(1, 2, 1))
        val second = DamageDistribution.fromRolls(listOf(1, 1, 2))
        assertEquals(first, second)
        assertEquals(first.hashCode(), second.hashCode())
        assertNotEquals(first, DamageDistribution.fromRolls(listOf(1, 2)))
        assertFalse(first.equals(null))
        assertFalse(first.equals("distribution"))
        assertEquals("DamageDistribution({1=2, 2=1})", first.toString())
    }
}
