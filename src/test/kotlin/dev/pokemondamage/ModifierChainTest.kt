package dev.pokemondamage

import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ModifierChainTest {
    @Test
    fun `chain preserves rule order and distinct application rounding`() {
        val chain = ModifierChain("Power", ModifierStage.POWER_MODIFIER)
        chain.add("First", 3)
        chain.add("Inactive", 8192, applies = false)
        chain.add("Second", 2048)
        val product = chain.finish()
        assertEquals(2, product.value) // 補正の連結では3 × 0.5を切り上げる。
        assertEquals(
            listOf(
                ModifierTrace("First", ModifierStage.POWER_MODIFIER, 3, 4096, 4096, 3),
                ModifierTrace("Second", ModifierStage.POWER_MODIFIER, 2048, 4096, 3, 2),
            ),
            product.trace,
        )
        val applied = chain.apply(3072, ModifierStage.POWER)
        assertEquals(1, applied.value) // 補正の適用では3072 × 2 / 4096 = 1.5を切り捨てる。
        assertEquals(
            product.trace + ModifierTrace("PowerModifiers", ModifierStage.POWER, 2, 4096, 3072, 1),
            applied.trace,
        )
    }

    @Test
    fun `traces are immutable snapshots even when the accumulator continues`() {
        val chain = ModifierChain("Attack", ModifierStage.ATTACK_MODIFIER)
        val empty = chain.finish()
        assertEquals(4096, empty.value)
        assertEquals(emptyList(), empty.trace)
        chain.add("HugePower", 8192)
        val before = chain.apply(100, ModifierStage.ATTACK)
        chain.add("ChoiceBand", 6144)
        assertEquals(200, before.value)
        assertEquals(2, before.trace.size)
        assertEquals(300, chain.apply(100, ModifierStage.ATTACK).value)
        assertEquals(emptyList(), empty.trace)
        assertFailsWith<UnsupportedOperationException> { (before.trace as MutableList).clear() }
    }

    @Test
    fun `stat application applies minimum before unsigned wrapping`() {
        val chain = ModifierChain("Defense", ModifierStage.DEFENSE_MODIFIER)
        assertEquals(1, chain.apply(0, ModifierStage.DEFENSE).value)
        assertEquals(0, chain.apply(65536, ModifierStage.DEFENSE).value)
        assertEquals(65535, chain.apply(65535, ModifierStage.DEFENSE).value)
        assertEquals(
            0L,
            chain
                .apply(0, ModifierStage.DEFENSE)
                .trace
                .last()
                .after,
        )
    }
}
