package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.ToxicCounter
import java.math.BigInteger

/** 確率分岐を区別する状態。重みは状態のキーに含めない。 */
internal data class BattleProgress(
    val hp: Int,
    val itemConsumed: Boolean,
    val toxicCounter: ToxicCounter?,
    val cudChewTurn: Long?,
    val attackDamage: BigInteger = BigInteger.ZERO,
)
