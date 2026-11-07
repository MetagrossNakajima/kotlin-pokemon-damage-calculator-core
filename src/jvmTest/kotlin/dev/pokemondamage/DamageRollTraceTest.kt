package dev.pokemondamage

import dev.pokemondamage.math.DamageRoll
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DamageRollTraceTest {
    @Test
    fun `random STAB type burn and final modifiers retain each rounded intermediate`() {
        val r = DamageRoll.calculateTraced(101, 85, 0.25, true, 6144, 5324)
        assertEquals(19, r.value)
        assertEquals(
            listOf(
                ModifierTrace("Random", ModifierStage.DAMAGE, 85, 100, 101, 85),
                ModifierTrace("STAB", ModifierStage.DAMAGE, 6144, 4096, 85, 127),
                ModifierTrace("Type", ModifierStage.DAMAGE, 1, 4, 127, 31),
                ModifierTrace("Burn", ModifierStage.DAMAGE, 2048, 4096, 31, 15),
                ModifierTrace("FinalModifiers", ModifierStage.DAMAGE, 5324, 4096, 15, 19),
            ),
            r.trace,
        )
    }

    @Test
    fun `immune rolls remain zero and neutral rolls omit inactive modifiers`() {
        val immune = DamageRoll.calculateTraced(100, 100, 0.0, false, 4096, 4096)
        assertEquals(0, immune.value)
        assertEquals(listOf("Random", "Type", "FinalModifiers"), immune.trace.map { it.id })
        assertEquals(ModifierTrace("Type", ModifierStage.DAMAGE, 0, 1, 100, 0), immune.trace[1])
        val neutral = DamageRoll.calculateTraced(1, 85, 1.0, false, 4096, 4096)
        assertEquals(1, neutral.value)
        assertEquals(0L, neutral.trace.last().after)
        assertFailsWith<ClassCastException> { (neutral.trace as MutableList).clear() }
    }
}
