package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonFlags
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Terrain
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

class ReferenceFieldMoveTest {
    @TestFactory
    fun `field move effects match native complete damage when activated`() =
        javaClass
            .getResourceAsStream("/reference/field-moves.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(4, it.size) }
            .map { (effect, rows) ->
                dynamicTest("MoveId/$effect") {
                    assertEquals(listOf("false", "true"), rows.map { it[1] })
                    val pokemon =
                        PokemonState(
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.NORMAL),
                                PokemonWeight(100),
                            ),
                            Stats(200, 100, 100, 100, 100, 100),
                            ability = AbilityId("Illuminate"),
                        )
                    val results =
                        rows.map { c ->
                            val enabled = c[1].toBooleanStrict()
                            val field =
                                if (!enabled) {
                                    BattleField()
                                } else {
                                    when (effect) {
                                        "HelpingHand" -> {
                                            BattleField(
                                                effects = EnumFlags(FieldEffect.HELPING_HAND),
                                            )
                                        }

                                        "MistyTerrain" -> {
                                            BattleField(terrain = Terrain.MISTY)
                                        }

                                        "GrassyTerrain" -> {
                                            BattleField(terrain = Terrain.GRASS)
                                        }

                                        else -> {
                                            BattleField()
                                        }
                                    }
                                }
                            val a =
                                pokemon.copy(
                                    flags =
                                        PokemonFlags(
                                            mapOf(
                                                PokemonFlag.CHARGE to
                                                    (enabled && effect == "Charge"),
                                            ),
                                        ),
                                )
                            val move =
                                Move(
                                    MoveId(c[2]),
                                    PokemonType.valueOf(c[4]),
                                    c[3].toInt(),
                                    Category.valueOf(c[5]),
                                )
                            val result =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(DamageRequest(a, pokemon, move, field)),
                                ).value
                                    .hit
                                    .rolls
                            assertEquals(
                                c[6]
                                    .removePrefix("[")
                                    .removeSuffix("]")
                                    .split(',')
                                    .map(String::toInt),
                                result,
                                "$effect enabled=$enabled",
                            )
                            result
                        }
                    assertNotEquals(
                        results[0],
                        results[1],
                        "$effect must change the attack's damage",
                    )
                }
            }
}
