package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Weather

/** Fixed expectations migrated without recalculation from suppression.tsv.
 * Source: native reference calculator fixtures retained from the Kotlin port.
 */
internal data class SuppressionCase(
    val ability: String,
    val attackerAbility: String,
    val shield: Boolean,
    val resolved: String?,
    val damage: List<Int>,
    val species: String,
    val weather: Weather?,
)

internal object SuppressionCases {
    val all: List<SuppressionCase> by lazy {
        buildList {
            addAll(suppressionArmorTailToFriendGuard())
            addAll(suppressionFurCoatToMagicBounce())
            addAll(suppressionMagmaArmorToSolidRock())
            addAll(suppressionSoundproofToWindRider())
            addAll(suppressionWonderGuardToWonderSkin())
        }
    }
}
