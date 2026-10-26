package dev.pokemondamage.model

/** One hit and its ordered arithmetic trace. Fixed hits retain stats as metadata only. */
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
