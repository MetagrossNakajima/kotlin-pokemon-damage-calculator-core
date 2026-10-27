package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.fixtures.PreparationCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ReferencePreparationTest {
    @TestFactory
    fun `Judgment Ivy Cudgel and Shell Side Arm agree with native Reference preparation`():
        List<org.junit.jupiter.api.DynamicTest> {
        val rows =
            PreparationCases.all
        assertEquals(903, rows.size)
        val expectedCounts = mapOf("Judgment" to 71, "IvyCudgel" to 16, "ShellSideArm" to 816)
        val groups = rows.groupBy { it.move }
        assertEquals(expectedCounts.keys, groups.keys)
        return groups.flatMap { (name, cases) ->
            assertEquals(expectedCounts.getValue(name), cases.size)
            assertTrue(
                cases.map { it.damage }.distinct().size > 1,
                "$name must exercise different native final outputs",
            )
            cases.mapIndexed { index, row ->
                dynamicTest("MoveId/$name/${index + 1}/${row.species}/${row.ability}") {
                    val originalTypes = row.originalTypes
                    val profile =
                        PokemonProfile(
                            PokemonId(row.species),
                            PokemonTypes(originalTypes[0], originalTypes.getOrNull(1)),
                            PokemonWeight(40),
                        )
                    val attacker =
                        PokemonState(
                            profile,
                            Stats(200, row.attack, 100, row.specialAttack, 100, 100),
                            stages =
                                StatStages.fromValues(
                                    attack = row.attackStage,
                                    specialAttack = row.specialAttackStage,
                                ),
                            ability = AbilityId(row.ability),
                            item = row.item?.let(::ItemId),
                        )
                    val defender =
                        PokemonState(
                            profile.copy(
                                id = PokemonId("Mew"),
                                types = PokemonTypes(PokemonType.NORMAL),
                            ),
                            Stats(200, 100, row.defense, 100, row.specialDefense, 100),
                            stages =
                                StatStages.fromValues(
                                    defense = row.defenseStage,
                                    specialDefense = row.specialDefenseStage,
                                ),
                        )
                    val effects =
                        buildList {
                            if (row.wonderRoom) {
                                add(FieldEffect.WONDER_ROOM)
                            }
                            if (row.magicRoom) {
                                add(FieldEffect.MAGIC_ROOM)
                            }
                        }
                    val flags =
                        if (row.contact) EnumFlags(MoveFlag.CONTACT) else EnumFlags()
                    val move =
                        Move(
                            MoveId(row.move),
                            row.type,
                            row.power,
                            row.category,
                            flags = flags,
                        )
                    val context =
                        DamageContext(
                            DamageRequest(
                                attacker,
                                defender,
                                move,
                                BattleField(effects = EnumFlags(*effects.toTypedArray())),
                            ),
                        )
                    val description = row.toString()
                    assertEquals(row.expectedType, context.move.type, description)
                    // 旧参照実装は交差積で分類を一つに決める。同値時の分布は回帰テストで検証する。
                    // ここでは参照実装が選んだ分類の計算根拠を引き続き照合する。
                    if (!context.move.categoryTied) {
                        assertEquals(row.expectedCategory, context.move.category, description)
                        assertEquals(
                            row.expectedContact,
                            MoveFlag.CONTACT in context.move.flags,
                            description,
                        )
                    }
                    val calculated =
                        assertIs<Calculation.Success<DamageResult>>(
                            calculateDamage(context.request),
                        ).value
                    val expectedRolls =
                        row.damage
                    // 参照実装は無効時に単一の0を返すが、このAPIは16通りの乱数を保持する。
                    assertEquals(
                        if (expectedRolls.size == 1) {
                            List(16) { expectedRolls.single() }
                        } else {
                            expectedRolls
                        },
                        if (context.move.categoryTied &&
                            row.expectedCategory == Category.PHYSICAL
                        ) {
                            checkNotNull(calculated.alternativeHit).rolls
                        } else {
                            calculated.hit.rolls
                        },
                        description,
                    )
                }
            }
        }
    }
}
