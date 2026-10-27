package dev.pokemondamage

import dev.pokemondamage.fixtures.itemKoCases
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
        itemKoCases()
            .groupBy { it.item }
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
                                    item = if (c.enabled) ItemId(item) else null,
                                )
                            val hazards = c.hazards
                            val request =
                                CombinedDamageRequest.repeatSingleHit(
                                    DamageDistribution.fromRolls(listOf(c.damage)),
                                    defender,
                                    field =
                                        BattleField(
                                            weather =
                                                if (c.sand) {
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
                            val expectedHits = c.hits
                            assertEquals(1, c.chance, "reference is a guaranteed KO")
                            assertEquals(
                                expectedHits,
                                result.ko.possibleHits,
                                "$item enabled=${c.enabled}",
                            )
                            assertEquals(
                                expectedHits,
                                result.ko.guaranteedHits,
                                "$item enabled=${c.enabled}",
                            )
                            assertEquals(
                                ExactProbability(
                                    dev.pokemondamage.math.BigInteger.ONE,
                                    dev.pokemondamage.math.BigInteger.ONE,
                                ),
                                result.knockout,
                            )
                            assertEquals(dev.pokemondamage.math.BigInteger.ZERO, result.finalHp.min)
                            expectedHits
                        }
                    assertEquals(listOf(3, 4), counts, "$item must delay the KO versus no item")
                }
            }
}
