package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
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
import dev.pokemondamage.model.TeraType
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
            checkNotNull(javaClass.getResourceAsStream("/reference/preparation.tsv"))
                .bufferedReader()
                .useLines { lines ->
                    lines.filterNot { it.startsWith('#') }.map { it.split('\t') }.toList()
                }
        assertEquals(903, rows.size)
        val expectedCounts = mapOf("Judgment" to 71, "IvyCudgel" to 16, "ShellSideArm" to 816)
        val groups = rows.groupBy { it[13] }
        assertEquals(expectedCounts.keys, groups.keys)
        return groups.map { (name, cases) ->
            dynamicTest("MoveId/$name") {
                assertEquals(expectedCounts.getValue(name), cases.size)
                assertTrue(
                    cases.map { it[21] }.distinct().size > 1,
                    "$name must exercise different native final outputs",
                )
                for (row in cases) {
                    val originalTypes = row[22].split(',').map(PokemonType::valueOf)
                    val profile =
                        PokemonProfile(
                            PokemonId(row[0]),
                            PokemonTypes(originalTypes[0], originalTypes.getOrNull(1)),
                            PokemonWeight(40),
                        )
                    val attacker =
                        PokemonState(
                            profile,
                            Stats(200, row[3].toInt(), 100, row[4].toInt(), 100, 100),
                            stages =
                                StatStages.fromValues(
                                    attack = row[7].toInt(),
                                    specialAttack = row[8].toInt(),
                                ),
                            ability = AbilityId(row[1]),
                            item = row[2].takeUnless { it == "-" }?.let(::ItemId),
                        )
                    val defender =
                        PokemonState(
                            profile.copy(
                                id = PokemonId("Mew"),
                                types = PokemonTypes(PokemonType.NORMAL),
                            ),
                            Stats(200, 100, row[5].toInt(), 100, row[6].toInt(), 100),
                            stages =
                                StatStages.fromValues(
                                    defense = row[9].toInt(),
                                    specialDefense = row[10].toInt(),
                                ),
                        )
                    val effects =
                        buildList {
                            if (row[11].toBooleanStrict()) {
                                add(FieldEffect.WONDER_ROOM)
                            }
                            if (row[12].toBooleanStrict()) {
                                add(FieldEffect.MAGIC_ROOM)
                            }
                        }
                    val flags =
                        if (row[17].toBooleanStrict()) EnumFlags(MoveFlag.CONTACT) else EnumFlags()
                    val move =
                        Move(
                            MoveId(row[13]),
                            PokemonType.valueOf(row[14]),
                            row[15].toInt(),
                            Category.valueOf(row[16]),
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
                    val description = row.take(18).joinToString("/")
                    assertEquals(TeraType.valueOf(row[18]), context.move.type, description)
                    assertEquals(Category.valueOf(row[19]), context.move.category, description)
                    assertEquals(
                        row[20].toBooleanStrict(),
                        MoveFlag.CONTACT in context.move.flags,
                        description,
                    )
                    val calculated =
                        assertIs<Calculation.Success<DamageResult>>(
                            calculateDamage(context.request),
                        ).value
                    val expectedRolls =
                        row[21]
                            .removePrefix("[")
                            .removeSuffix("]")
                            .split(',')
                            .map(String::toInt)
                    // Reference represents an immune result as scalar 0; this API retains all 16
                    // rolls.
                    assertEquals(
                        if (expectedRolls.size == 1) {
                            List(16) { expectedRolls.single() }
                        } else {
                            expectedRolls
                        },
                        calculated.hit.rolls,
                        description,
                    )
                }
            }
        }
    }
}
