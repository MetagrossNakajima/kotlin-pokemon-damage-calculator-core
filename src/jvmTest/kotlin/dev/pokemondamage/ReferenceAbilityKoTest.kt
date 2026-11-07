package dev.pokemondamage

import dev.pokemondamage.fixtures.abilityKoCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.ExactProbability
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ReferenceAbilityKoTest {
    @TestFactory
    fun `combined abilities match native guaranteed KO attack counts`() =
        abilityKoCases()
            .groupBy { it.ability }
            .also { assertEquals(5, it.size) }
            .map { (ability, rows) ->
                dynamicTest("AbilityId/$ability") {
                    assertEquals(listOf(false, true), rows.map { it.enabled })
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
                                    ability =
                                        AbilityId(
                                            if (c.enabled) ability else "Illuminate",
                                        ),
                                    status = c.status,
                                )
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
                                )
                            val result =
                                assertIs<Calculation.Success<CombinedDamageResult>>(
                                    calculateCombinedDamage(request),
                                ).value
                            val expectedHits = c.hits
                            assertEquals(1, c.chance)
                            assertEquals(
                                expectedHits,
                                result.ko.possibleHits,
                                "$ability enabled=${c.enabled}",
                            )
                            assertEquals(
                                expectedHits,
                                result.ko.guaranteedHits,
                                "$ability enabled=${c.enabled}",
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
                    assertTrue(counts[1] > counts[0], "$ability must delay KO versus its control")
                }
            }
}
