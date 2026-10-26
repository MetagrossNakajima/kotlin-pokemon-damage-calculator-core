package dev.pokemondamage

import dev.pokemondamage.model.*
import java.math.BigInteger
import kotlin.test.*

class CalculationResultTest {
    @Test
    fun `single hit exposes exact weights percentages and immutable calculation evidence`() {
        val rolls = mutableListOf(19, 20, 20, 23)
        val step = ModifierTrace("STAB", ModifierStage.DAMAGE, 6144, 4096, 13, 19)
        val trace = mutableListOf(step)
        val hit = HitResult(100, 123, 111, false, rolls, trace)
        val result = DamageResult(hit, 200)
        rolls.clear()
        trace.clear()
        assertSame(hit, result.hit)
        assertEquals(200, result.referenceHp)
        assertEquals(100, hit.power)
        assertEquals(123, hit.attack)
        assertEquals(111, hit.defense)
        assertFalse(hit.critical)
        assertEquals(DamageKind.NORMAL, hit.kind)
        assertEquals(listOf(19, 20, 20, 23), hit.rolls)
        assertEquals(listOf(step), hit.trace)
        assertEquals(DamageDistribution.fromRolls(listOf(19, 20, 20, 23)), result.distribution)
        assertEquals(BigInteger.valueOf(4), result.distribution.totalWeight)
        assertEquals(19, result.min)
        assertEquals(23, result.max)
        assertEquals(9.5, result.minPercent)
        assertEquals(11.5, result.maxPercent)
        assertEquals("STAB", step.id)
        assertEquals(ModifierStage.DAMAGE, step.stage)
        assertEquals(6144L, step.numerator)
        assertEquals(4096L, step.denominator)
        assertEquals(13L, step.before)
        assertEquals(19L, step.after)
        assertFailsWith<UnsupportedOperationException> { (hit.rolls as MutableList).clear() }
        assertFailsWith<UnsupportedOperationException> { (hit.trace as MutableList).clear() }
        for (invalid in listOf(0, 1000)) assertFailsWith<IllegalArgumentException> {
            result.copy(referenceHp = invalid)
        }
    }

    @Test
    fun `fixed damage and critical metadata are not inferred from input stats`() {
        val fixed = HitResult(0, 100, 200, false, listOf(50), emptyList(), DamageKind.FIXED)
        assertEquals(DamageKind.FIXED, fixed.kind)
        assertEquals(0, fixed.power)
        assertEquals(50, DamageResult(fixed, 999).max)
        assertEquals(50, DamageResult(fixed, 1).min)
        assertEquals(5000.0, DamageResult(fixed, 1).maxPercent)
        val critical = HitResult(90, 100, 200, true, listOf(1), emptyList())
        assertTrue(critical.critical)
        assertFailsWith<IllegalArgumentException> {
            HitResult(90, 100, 200, false, emptyList(), emptyList())
        }
        assertFailsWith<IllegalArgumentException> {
            HitResult(90, 100, 200, false, listOf(-1), emptyList())
        }
    }

    @Test
    fun `calculation success and failure retain values and diagnostic paths`() {
        val success: Calculation<Int> = Calculation.Success(42)
        val unsupported: Calculation<Int> =
            Calculation.Failure(FailureKind.UNSUPPORTED, "move.Counter")
        val exceeded: Calculation<Int> =
            Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "attacks[2]")
        assertEquals(42, assertIs<Calculation.Success<Int>>(success).value)
        assertEquals(FailureKind.UNSUPPORTED, assertIs<Calculation.Failure>(unsupported).kind)
        assertEquals("move.Counter", unsupported.path)
        assertEquals(FailureKind.COMPLEXITY_EXCEEDED, assertIs<Calculation.Failure>(exceeded).kind)
        assertEquals("attacks[2]", exceeded.path)
    }
}
