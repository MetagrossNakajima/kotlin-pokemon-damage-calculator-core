package dev.pokemondamage.engine.power

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.rules.MoveRules

/** 技威力に補正を順に適用し、符号なし整数に収めてからテラスタルの最低威力を適用する。 */
internal object FinalPower {
    fun calculate(context: DamageContext): TracedValue {
        val move = context.move.original
        val base = BasePower.calculate(context)
        val modified = PowerModifiers.calculate(context, base).apply(base, ModifierStage.POWER)
        val baseTrace =
            ModifierTrace(
                move.id.value,
                ModifierStage.BASE_POWER,
                base,
                maxOf(1, move.power).toLong(),
                move.power.toLong(),
                base,
            )
        val trace = listOf(baseTrace) + modified.trace
        val attacker = context.attacker
        // テラスタルのタイプ強化対象か判定
        val teraBoost =
            attacker.teraType == context.move.type ||
                (
                    attacker.teraType == TeraType.STELLAR &&
                        (
                            attacker.flags[PokemonFlag.STELLAR_BOOST_AVAILABLE] != false ||
                                attacker.profile.id == PokemonId("Terapagos-Stellar")
                        )
                )
        // 対象技の威力を最低60に引き上げる
        return if (
            teraBoost &&
            !MoveRules.isNaturalMultiHit(move.id) &&
            move.priority <= 0 &&
            move.id.value !in hpMoves &&
            modified.value < 60
        ) {
            TracedValue(
                60,
                trace +
                    ModifierTrace(
                        "TeraMinimum",
                        ModifierStage.POWER,
                        60,
                        modified.value.toLong(),
                        modified.value.toLong(),
                        60,
                    ),
            )
        } else {
            TracedValue(modified.value, trace)
        }
    }

    private val hpMoves = setOf("Eruption", "WaterSpout", "DragonEnergy")
}
