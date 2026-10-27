package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.PokemonType

/** Fixed expectations migrated without recalculation from field-moves.tsv.
 * Source: native reference calculator fixtures retained from the Kotlin port.
 */
internal data class FieldMoveCase(
    val effect: String,
    val enabled: Boolean,
    val move: String,
    val power: Int,
    val type: PokemonType,
    val category: Category,
    val damage: List<Int>,
)

internal object FieldMoveCases {
    val all: List<FieldMoveCase> by lazy {
        buildList {
            addAll(part0())
        }
    }

    private fun part0(): List<FieldMoveCase> =
        listOf(
            FieldMoveCase(
                effect = "HelpingHand",
                enabled = false,
                move = "Tackle",
                power = 40,
                type = PokemonType.NORMAL,
                category = Category.PHYSICAL,
                damage = listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
            ),
            FieldMoveCase(
                effect = "HelpingHand",
                enabled = true,
                move = "Tackle",
                power = 40,
                type = PokemonType.NORMAL,
                category = Category.PHYSICAL,
                damage = listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
            ),
            FieldMoveCase(
                effect = "Charge",
                enabled = false,
                move = "Thunderbolt",
                power = 90,
                type = PokemonType.ELECTRIC,
                category = Category.SPECIAL,
                damage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            ),
            FieldMoveCase(
                effect = "Charge",
                enabled = true,
                move = "Thunderbolt",
                power = 90,
                type = PokemonType.ELECTRIC,
                category = Category.SPECIAL,
                damage = listOf(68, 69, 70, 71, 72, 72, 73, 74, 75, 76, 76, 77, 78, 79, 80, 81),
            ),
            FieldMoveCase(
                effect = "MistyTerrain",
                enabled = false,
                move = "DragonPulse",
                power = 85,
                type = PokemonType.DRAGON,
                category = Category.SPECIAL,
                damage = listOf(33, 33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39),
            ),
            FieldMoveCase(
                effect = "MistyTerrain",
                enabled = true,
                move = "DragonPulse",
                power = 85,
                type = PokemonType.DRAGON,
                category = Category.SPECIAL,
                damage = listOf(17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20),
            ),
            FieldMoveCase(
                effect = "GrassyTerrain",
                enabled = false,
                move = "Earthquake",
                power = 100,
                type = PokemonType.GROUND,
                category = Category.PHYSICAL,
                damage = listOf(39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46),
            ),
            FieldMoveCase(
                effect = "GrassyTerrain",
                enabled = true,
                move = "Earthquake",
                power = 100,
                type = PokemonType.GROUND,
                category = Category.PHYSICAL,
                damage = listOf(20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 24),
            ),
        )
}
