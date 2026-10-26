package dev.pokemondamage.model

import java.math.BigInteger

/**
 * Final mutable battle values alongside the immutable original combatant (including all metadata).
 */
data class BattleState(
    val initialPokemon: PokemonState,
    val currentHp: Int,
    val itemConsumed: Boolean,
    val toxicCounter: ToxicCounter?,
    val cudChewTurn: Long?,
)

data class WeightedBattleState(
    val state: BattleState,
    val weight: BigInteger,
)
