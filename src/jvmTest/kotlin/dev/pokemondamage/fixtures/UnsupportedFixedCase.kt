package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.PokemonType

// Fixed expectations migrated from reference/fixed-unsupported.tsv.
// Native reference parity; the original fixture did not record a version in its header.
// Expectations are literals, independent of the implementation under test.
internal data class UnsupportedFixedCase(
    val move: String,
    val type: PokemonType,
    val category: Category,
    val attackerHp: Int,
    val defenderHp: Int,
    val nativeDamage: Int,
)

internal fun unsupportedFixedCases(): List<UnsupportedFixedCase> =
    buildList {
        addAll(unsupportedFixedCasesPart1())
        addAll(unsupportedFixedCasesPart2())
    }

private fun unsupportedFixedCasesPart1(): List<UnsupportedFixedCase> =
    listOf(
        UnsupportedFixedCase(
            move = "SuperFang",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SuperFang",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SuperFang",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SuperFang",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Ruination",
            type = PokemonType.DARK,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Ruination",
            type = PokemonType.DARK,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Ruination",
            type = PokemonType.DARK,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Ruination",
            type = PokemonType.DARK,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Endeavor",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Endeavor",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Endeavor",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Endeavor",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Fissure",
            type = PokemonType.GROUND,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Fissure",
            type = PokemonType.GROUND,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Fissure",
            type = PokemonType.GROUND,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Fissure",
            type = PokemonType.GROUND,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SheerCold",
            type = PokemonType.ICE,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SheerCold",
            type = PokemonType.ICE,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SheerCold",
            type = PokemonType.ICE,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "SheerCold",
            type = PokemonType.ICE,
            category = Category.SPECIAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
    )

private fun unsupportedFixedCasesPart2(): List<UnsupportedFixedCase> =
    listOf(
        UnsupportedFixedCase(
            move = "HornDrill",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "HornDrill",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "HornDrill",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "HornDrill",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Guillotine",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 1,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Guillotine",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 3,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Guillotine",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 101,
            nativeDamage = 0,
        ),
        UnsupportedFixedCase(
            move = "Guillotine",
            type = PokemonType.NORMAL,
            category = Category.PHYSICAL,
            attackerHp = 40,
            defenderHp = 200,
            nativeDamage = 0,
        ),
    )
