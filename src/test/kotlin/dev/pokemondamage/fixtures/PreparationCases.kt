package dev.pokemondamage.fixtures

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType

/** Fixed expectations migrated without recalculation from preparation.tsv.
 * reference calculator 0.12.0; generation 9; tools/reference/generate-preparation.cjs
 */
internal data class PreparationCase(
    val species: String,
    val ability: String,
    val item: String?,
    val attack: Int,
    val specialAttack: Int,
    val defense: Int,
    val specialDefense: Int,
    val attackStage: Int,
    val specialAttackStage: Int,
    val defenseStage: Int,
    val specialDefenseStage: Int,
    val wonderRoom: Boolean,
    val magicRoom: Boolean,
    val move: String,
    val type: PokemonType,
    val power: Int,
    val category: Category,
    val contact: Boolean,
    val expectedType: TeraType,
    val expectedCategory: Category,
    val expectedContact: Boolean,
    val damage: List<Int>,
    val originalTypes: List<PokemonType>,
)

internal object PreparationCases {
    val all: List<PreparationCase> by lazy {
        buildList {
            addAll(preparationJudgment1())
            addAll(preparationJudgment2())
            addAll(preparationIvyCudgel())
            addAll(preparationShellSideArm1())
            addAll(preparationShellSideArm2())
            addAll(preparationShellSideArm3())
            addAll(preparationShellSideArm4())
            addAll(preparationShellSideArm5())
            addAll(preparationShellSideArm6())
            addAll(preparationShellSideArm7())
            addAll(preparationShellSideArm8())
            addAll(preparationShellSideArm9())
            addAll(preparationShellSideArm10())
            addAll(preparationShellSideArm11())
            addAll(preparationShellSideArm12())
            addAll(preparationShellSideArm13())
            addAll(preparationShellSideArm14())
        }
    }
}
