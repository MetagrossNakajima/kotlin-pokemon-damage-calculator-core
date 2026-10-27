package dev.pokemondamage.model

import java.math.BigInteger

/** 変化後の最終状態と、メタデータを含む変更前のポケモン情報を保持する。 */
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
