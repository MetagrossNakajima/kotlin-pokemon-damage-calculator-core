package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleSetup
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.EntryHazards
import dev.pokemondamage.model.ExactProbability
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ReferenceItemKoTest {
    @TestFactory
    fun `combined item effects match native guaranteed KO attack counts`() =
        javaClass
            .getResourceAsStream("/reference/item-ko.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(3, it.size) }
            .map { (item, rows) ->
                dynamicTest("ItemId/$item") {
                    val counts =
                        rows.map { c ->
                            val defender =
                                PokemonState(
                                    PokemonProfile(
                                        PokemonId("Mew"),
                                        PokemonTypes(PokemonType.NORMAL),
                                        PokemonWeight(100),
                                    ),
                                    Stats(100, 100, 100, 100, 100, 100),
                                    ability = AbilityId("Illuminate"),
                                    item = if (c[1].toBooleanStrict()) ItemId(item) else null,
                                )
                            val hazards = c[3].toBooleanStrict()
                            val request =
                                CombinedDamageRequest.repeatSingleHit(
                                    DamageDistribution.fromRolls(listOf(c[2].toInt())),
                                    defender,
                                    field =
                                        BattleField(
                                            weather =
                                                if (c[4].toBooleanStrict()) {
                                                    Weather.SANDSTORM
                                                } else {
                                                    null
                                                },
                                        ),
                                    setup =
                                        BattleSetup(
                                            EntryHazards(
                                                hazards,
                                                if (hazards) Spikes.TWO_LAYERS else Spikes.NONE,
                                            ),
                                        ),
                                )
                            val result =
                                assertIs<Calculation.Success<CombinedDamageResult>>(
                                    calculateCombinedDamage(request),
                                ).value
                            val expectedHits = c[5].toInt()
                            assertEquals("1", c[6], "reference is a guaranteed KO")
                            assertEquals(
                                expectedHits,
                                result.ko.possibleHits,
                                "$item enabled=${c[1]}",
                            )
                            assertEquals(
                                expectedHits,
                                result.ko.guaranteedHits,
                                "$item enabled=${c[1]}",
                            )
                            assertEquals(
                                ExactProbability(
                                    java.math.BigInteger.ONE,
                                    java.math.BigInteger.ONE,
                                ),
                                result.knockout,
                            )
                            assertEquals(java.math.BigInteger.ZERO, result.finalHp.min)
                            expectedHits
                        }
                    assertEquals(listOf(3, 4), counts, "$item must delay the KO versus no item")
                }
            }
}
