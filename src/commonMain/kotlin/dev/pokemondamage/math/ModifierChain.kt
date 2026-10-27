package dev.pokemondamage.math

import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace

/** 4096を基準とする補正列。連結時と能力値への適用時で丸め方が異なる。 */
internal class ModifierChain(
    private val name: String,
    private val stage: ModifierStage,
) {
    private val trace = mutableListOf<ModifierTrace>()
    private val multiplier: Int
        get() = trace.lastOrNull()?.after?.toInt() ?: BattleMath.UNIT

    fun add(
        id: String,
        numerator: Int,
        applies: Boolean = true,
    ) {
        if (!applies) {
            return
        }
        val before = multiplier
        val after = BattleMath.chain(before, numerator)
        trace +=
            ModifierTrace(
                id,
                stage,
                numerator.toLong(),
                BattleMath.UNIT.toLong(),
                before.toLong(),
                after.toLong(),
            )
    }

    /** 乱数ごとに適用する最終ダメージ補正を返す。 */
    fun finish(): TracedValue = TracedValue(multiplier, trace)

    /** 能力値や威力に補正を適用し、最低1にして16ビットに収める。 */
    fun apply(
        input: Int,
        valueStage: ModifierStage,
    ): TracedValue = apply(input.toLong(), valueStage)

    fun apply(
        input: Long,
        valueStage: ModifierStage,
    ): TracedValue {
        // 補正をまとめて適用し、五捨五超入
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
        // 最低1にしてから16ビットに収める
        return TracedValue((maxOf(1, modified) and 0xffff).toInt(), trace + application)
    }
}
