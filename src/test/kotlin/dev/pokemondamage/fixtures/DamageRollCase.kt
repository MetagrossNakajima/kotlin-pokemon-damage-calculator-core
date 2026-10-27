package dev.pokemondamage.fixtures

// Original reference calculator 0.12.0, generation 9; tools/reference/generate.cjs. Expected
// values copied unchanged.

/** Expected damage for random percentages 85 through 100, in that order. */
internal data class DamageRollCase(
    val baseDamage: Int,
    val effectiveness: Double,
    val burned: Boolean,
    val stab: Int,
    val finalModifier: Int,
    val expectedRolls: List<Int>,
)

internal fun damageRollCases(): List<DamageRollCase> =
    buildList {
        addAll(damageRollBase2Part1())
        addAll(damageRollBase2Part2())
        addAll(damageRollBase2Part3())
        addAll(damageRollBase2Part4())
        addAll(damageRollBase2Part5())
        addAll(damageRollBase3Part1())
        addAll(damageRollBase3Part2())
        addAll(damageRollBase3Part3())
        addAll(damageRollBase3Part4())
        addAll(damageRollBase3Part5())
        addAll(damageRollBase46Part1())
        addAll(damageRollBase46Part2())
        addAll(damageRollBase46Part3())
        addAll(damageRollBase46Part4())
        addAll(damageRollBase46Part5())
        addAll(damageRollBase999Part1())
        addAll(damageRollBase999Part2())
        addAll(damageRollBase999Part3())
        addAll(damageRollBase999Part4())
        addAll(damageRollBase999Part5())
        addAll(damageRollBase65535Part1())
        addAll(damageRollBase65535Part2())
        addAll(damageRollBase65535Part3())
        addAll(damageRollBase65535Part4())
        addAll(damageRollBase65535Part5())
        addAll(damageRollBase1000000Part1())
        addAll(damageRollBase1000000Part2())
        addAll(damageRollBase1000000Part3())
        addAll(damageRollBase1000000Part4())
        addAll(damageRollBase1000000Part5())
        addAll(damageRollBase85841676Part1())
        addAll(damageRollBase85841676Part2())
        addAll(damageRollBase85841676Part3())
        addAll(damageRollBase85841676Part4())
        addAll(damageRollBase85841676Part5())
    }
