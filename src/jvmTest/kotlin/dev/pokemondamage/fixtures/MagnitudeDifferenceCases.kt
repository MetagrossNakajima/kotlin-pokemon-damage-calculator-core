package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.Weather

/** Fixed expectations migrated without recalculation from magnitude-difference.tsv.
 * Source: native reference calculator fixtures retained from the Kotlin port.
 */
internal data class MagnitudeDifferenceCase(
    val move: String,
    val enabled: Boolean,
    val power: Int,
    val type: PokemonType,
    val category: Category,
    val flags: List<MoveFlag>,
    val attackerHp: Int,
    val defenderHp: Int,
    val attackerStatus: Status?,
    val defenderStatus: Status?,
    val attackerItem: String?,
    val weather: Weather?,
    val terrain: Terrain?,
    val gravity: Boolean,
    val attackerWeight: Int,
    val defenderWeight: Int,
    val attackerStages: StatStages,
    val defenderType: PokemonType,
    val damage: List<Int>,
    val defenderAbility: String,
    val attackerTera: TeraType?,
    val attackerSpecies: String,
    val screen: Boolean,
    val defenderStages: StatStages,
    val genericDamage: List<Int>?,
    val defenderItem: String?,
    val movesFirst: Boolean,
)

internal object MagnitudeDifferenceCases {
    val all: List<MagnitudeDifferenceCase> by lazy {
        buildList {
            addAll(part0())
        }
    }

    private fun part0(): List<MagnitudeDifferenceCase> =
        listOf(
            MagnitudeDifferenceCase(
                move = "Magnitude",
                enabled = false,
                power = 70,
                type = PokemonType.GROUND,
                category = Category.PHYSICAL,
                flags = listOf(),
                attackerHp = 200,
                defenderHp = 200,
                attackerStatus = null,
                defenderStatus = null,
                attackerItem = null,
                weather = null,
                terrain = null,
                gravity = false,
                attackerWeight = 100,
                defenderWeight = 100,
                attackerStages = StatStages.fromValues(0, 0, 0, 0, 0),
                defenderType = PokemonType.NORMAL,
                damage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
                defenderAbility = "Illuminate",
                attackerTera = null,
                attackerSpecies = "Mew",
                screen = false,
                defenderStages = StatStages.fromValues(0, 0, 0, 0, 0),
                genericDamage = null,
                defenderItem = null,
                movesFirst = false,
            ),
            MagnitudeDifferenceCase(
                move = "Magnitude",
                enabled = true,
                power = 70,
                type = PokemonType.GROUND,
                category = Category.PHYSICAL,
                flags = listOf(),
                attackerHp = 200,
                defenderHp = 200,
                attackerStatus = null,
                defenderStatus = null,
                attackerItem = null,
                weather = null,
                terrain = Terrain.GRASS,
                gravity = false,
                attackerWeight = 100,
                defenderWeight = 100,
                attackerStages = StatStages.fromValues(0, 0, 0, 0, 0),
                defenderType = PokemonType.NORMAL,
                damage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
                defenderAbility = "Illuminate",
                attackerTera = null,
                attackerSpecies = "Mew",
                screen = false,
                defenderStages = StatStages.fromValues(0, 0, 0, 0, 0),
                genericDamage = null,
                defenderItem = null,
                movesFirst = false,
            ),
        )
}
