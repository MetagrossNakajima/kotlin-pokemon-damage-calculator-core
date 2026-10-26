package dev.pokemondamage.math

import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace

/** Ordered 4096-based modifiers. Chaining and stat application have distinct rounding rules. */
internal class ModifierChain(private val name: String, private val stage: ModifierStage) {
    private var multiplier = BattleMath.UNIT
    private val trace = mutableListOf<ModifierTrace>()

    fun add(id: String, numerator: Int, applies: Boolean = true) {
        if (!applies) return
        val before = multiplier
        multiplier = BattleMath.chain(before, numerator)
        trace +=
            ModifierTrace(
                id,
                stage,
                numerator.toLong(),
                BattleMath.UNIT.toLong(),
                before.toLong(),
                multiplier.toLong(),
            )
    }

    /** Used for damage modifiers, which are applied independently to each random roll. */
    fun finish(): TracedValue = TracedValue(multiplier, trace)

    /** Applies the chain to a stat or power, including minimum-one and 16-bit wrap. */
    fun apply(input: Int, valueStage: ModifierStage): TracedValue =
        apply(input.toLong(), valueStage)

    fun apply(input: Long, valueStage: ModifierStage): TracedValue {
        val modified = (input * multiplier * 2 + BattleMath.UNIT - 1) / (BattleMath.UNIT * 2L)
        val application =
            ModifierTrace(
                "${name}Modifiers",
                valueStage,
                multiplier.toLong(),
                BattleMath.UNIT.toLong(),
                input,
                modified,
            )
        return TracedValue((maxOf(1, modified) and 0xffff).toInt(), trace + application)
    }
}
