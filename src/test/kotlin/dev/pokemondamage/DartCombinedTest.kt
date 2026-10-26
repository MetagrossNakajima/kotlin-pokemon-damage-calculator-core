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
import dev.pokemondamage.model.KoInfo
import dev.pokemondamage.model.KoStatus
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.ToxicCounter
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertIs

class DartCombinedTest {
    @TestFactory
    fun `combined API matches Dart HP damage KO counts and final states`(): List<DynamicTest> {
        val rows =
            javaClass
                .getResourceAsStream("/dart/combined.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
                .map { it.split('\t') }
        assertEquals(810, rows.size)
        val dimensions = mapOf("ItemId" to 2, "AbilityId" to 1)
        return dimensions.flatMap { (kind, column) ->
            fun key(c: List<String>) = c.take(5).filterIndexed { index, _ -> index != column }
            val controls = rows.filter { it[column] == "-" }.associateBy(::key)
            val groups = rows.groupBy { it[column] }
            val ids =
                if (kind == "ItemId") {
                    setOf("-", "SitrusBerry", "Leftovers", "Heavy-DutyBoots", "SafetyGoggles")
                } else {
                    setOf(
                        "-",
                        "CudChew",
                        "PoisonHeal",
                        "MagicGuard",
                        "CheekPouch",
                        "Ripen",
                        "Overcoat",
                        "SandRush",
                        "SandVeil",
                    )
                }
            assertEquals(ids, groups.keys)
            groups.map { (id, cases) ->
                dynamicTest("$kind/$id") {
                    assertEquals(if (kind == "ItemId") 162 else 90, cases.size)
                    val results = cases.map { c -> c to verifyCase(c) }
                    val changedHp =
                        results.any { (c, result) ->
                            result.finalHp.weights != distribution(controls.getValue(key(c))[5])
                        }
                    val consumed =
                        results.any { (_, result) ->
                            result.finalStates.any { it.state.itemConsumed }
                        }
                    assertEquals(
                        id != "-",
                        changedHp,
                        "$kind/$id must change HP versus its control",
                    )
                    if (kind == "ItemId") {
                        assertEquals(id == "SitrusBerry", consumed, "only Sitrus Berry is consumed")
                    }
                }
            }
        }
    }

    private fun distribution(text: String) =
        text.split(',').associate { entry ->
            entry.split(':').let { it[0].toBigInteger() to it[1].toBigInteger() }
        }

    private fun verifyCase(c: List<String>): CombinedDamageResult {
        val label = c.take(5).joinToString("/")
        val status = c[3].takeUnless { it == "-" }?.let(Status::valueOf)
        val defender =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(100, 100, 100, 100, 100, 100),
                ability = c[1].takeUnless { it == "-" }?.let(::AbilityId),
                item = c[2].takeUnless { it == "-" }?.let(::ItemId),
                status = status,
                toxicCounter = if (status == Status.TOXIC) ToxicCounter(1) else null,
            )
        val hazards = c[4].toBooleanStrict()
        val request =
            CombinedDamageRequest.repeatSingleHit(
                DamageDistribution.fromRolls(listOf(20, 40, 40)),
                defender,
                DamageDistribution.fromRolls(listOf(30, 60)),
                c[0].toInt(),
                field = BattleField(weather = Weather.SANDSTORM, terrain = Terrain.GRASS),
                setup =
                    BattleSetup(
                        EntryHazards(hazards, if (hazards) Spikes.TWO_LAYERS else Spikes.NONE),
                        listOf(3.toBigInteger()),
                    ),
            )
        val result =
            assertIs<Calculation.Success<CombinedDamageResult>>(calculateCombinedDamage(request))
                .value
        val expectedHp = distribution(c[5])
        assertEquals(expectedHp, result.finalHp.weights, "$label HP")
        assertEquals(distribution(c[6]), result.attackDamage.weights, "$label damage")
        val koStatus =
            when (c[7]) {
                "resolved" -> KoStatus.RESOLVED
                "limitReached" -> KoStatus.LIMIT_REACHED
                else -> KoStatus.NOT_APPLICABLE
            }
        assertEquals(
            KoInfo(koStatus, 4, c[8].toIntOrNull(), c[9].toIntOrNull()),
            result.ko,
            "$label KO",
        )
        val states =
            result.finalStates
                .map { entry ->
                    with(entry.state) {
                        "$currentHp:$itemConsumed:${toxicCounter?.value ?: "-"}:" +
                            "${cudChewTurn ?: "-"}:${entry.weight}"
                    }
                }.sorted()
                .joinToString(",")
        assertEquals(c[10], states, "$label states")
        assertEquals(
            ExactProbability(
                expectedHp[BigInteger.ZERO] ?: BigInteger.ZERO,
                expectedHp.values.reduce(BigInteger::add),
            ),
            result.knockout,
            "$label knockout probability",
        )
        return result
    }
}
