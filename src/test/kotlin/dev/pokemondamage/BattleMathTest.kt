package dev.pokemondamage

import dev.pokemondamage.math.BattleMath
import kotlin.test.Test
import kotlin.test.assertEquals

class BattleMathTest {
    @Test
    fun `application rounds halves down but chaining rounds them up`() {
        assertEquals(1, BattleMath.modify(3, 2048))
        assertEquals(2, BattleMath.chain(3, 2048))
        assertEquals(1, BattleMath.modify(1, 6143))
        assertEquals(1, BattleMath.modify(1, 6144))
        assertEquals(2, BattleMath.modify(1, 6145))
        assertEquals(3, BattleMath.modify(5, 2, 3))
    }

    @Test
    fun `intermediate products use wide integers`() {
        assertEquals(65535, BattleMath.modify(65535, 65536, 65536))
        assertEquals(1048576, BattleMath.chain(65536, 65536))
    }

    @Test
    fun `unsigned arithmetic wraps at the game boundaries`() {
        assertEquals(65535, BattleMath.unsigned16(-1))
        assertEquals(0, BattleMath.unsigned16(65536))
        assertEquals(4294967295L, BattleMath.unsigned32(-1))
        assertEquals(0L, BattleMath.unsigned32(4294967296L))
        assertEquals(0, BattleMath.modifyDamage(1048576, 4096))
        assertEquals(1, BattleMath.modifyDamage(3, 2048))
    }

    @Test
    fun `all stat stages floor the rational multiplier`() {
        val expected = listOf(25, 28, 33, 40, 50, 67, 101, 151, 202, 252, 303, 353, 404)
        assertEquals(expected, (-6..6).map { BattleMath.rankedStat(101, it) })
        assertEquals(0, BattleMath.rankedStat(8192, 6))
        assertEquals(0, BattleMath.rankedStat(32768, -1))
    }

    @Test
    fun `base damage uses level fifty and integer division`() {
        assertEquals(46, BattleMath.baseDamage(100, 100, 100))
        assertEquals(35, BattleMath.baseDamage(80, 123, 131))
        assertEquals(28835402, BattleMath.baseDamage(1000, 65535, 1))
        assertEquals(85841676, BattleMath.baseDamage(65535, 65535, 1))
    }
}
