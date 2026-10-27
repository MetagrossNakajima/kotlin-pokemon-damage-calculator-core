package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Gender
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.Weather

/** Fixed expectations migrated without recalculation from effect-pairs.tsv.
 * Source: native reference calculator fixtures retained from the Kotlin port.
 */
internal data class EffectPairsCase(
    val effect: String,
    val enabled: Boolean,
    val attackerAbility: String,
    val defenderAbility: String,
    val attackerItem: String?,
    val defenderItem: String?,
    val type: PokemonType,
    val defenderType: PokemonType,
    val category: Category,
    val contact: Boolean,
    val sound: Boolean,
    val bullet: Boolean,
    val wind: Boolean,
    val critical: Boolean,
    val damage: List<Int>,
    val attackerSpecies: String,
    val defenderSpecies: String,
    val weather: Weather?,
    val move: String,
    val fieldEffect: FieldEffect?,
    val screen: Boolean,
    val defenderStatus: Status?,
    val attackerStage: Int,
    val attackerGender: Gender,
    val defenderGender: Gender,
    val fainted: Int,
)

internal object EffectPairsCases {
    val all: List<EffectPairsCase> by lazy {
        buildList {
            addAll(effectPairsItemId())
            addAll(effectPairsAbilityId())
            addAll(effectPairsItemId1())
            addAll(effectPairsItemId2())
            addAll(effectPairsItemId3())
            addAll(effectPairsAbilityId1())
            addAll(effectPairsAbilityId2())
        }
    }
}
