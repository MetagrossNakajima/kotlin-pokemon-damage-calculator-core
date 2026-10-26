package dev.pokemondamage.model

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
    val rolls: List<Int> = java.util.List.copyOf(rolls)
    val trace: List<ModifierTrace> = java.util.List.copyOf(trace)
    val distribution: DamageDistribution = DamageDistribution.fromRolls(this.rolls)
}

enum class DamageKind {
    NORMAL,
    FIXED,
}
