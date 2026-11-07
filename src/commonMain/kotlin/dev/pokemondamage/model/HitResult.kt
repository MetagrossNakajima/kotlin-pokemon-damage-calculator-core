package dev.pokemondamage.model

import dev.pokemondamage.collections.ImmutableCollections

/** 1発分の結果と計算順の履歴。固定ダメージ技の能力値は付随情報としてのみ保持する。 */
class HitResult(
    val power: Int,
    val attack: Int,
    val defense: Int,
    val critical: Boolean,
    rolls: List<Int>,
    trace: List<ModifierTrace>,
    val kind: DamageKind = DamageKind.NORMAL,
) {
    val rolls: List<Int> = ImmutableCollections.unmodifiableList(rolls)
    val trace: List<ModifierTrace> = ImmutableCollections.unmodifiableList(trace)
    val distribution: DamageDistribution = DamageDistribution.fromRolls(this.rolls)
}

enum class DamageKind {
    NORMAL,
    FIXED,
}
