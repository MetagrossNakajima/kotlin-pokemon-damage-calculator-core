package dev.pokemondamage

import dev.pokemondamage.fixtures.DartCombinedCase
import dev.pokemondamage.fixtures.ExpectedCombinedState
import dev.pokemondamage.fixtures.dartCombinedCases
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.math.toBigInteger
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
import kotlin.test.assertEquals
import kotlin.test.assertIs

class DartCombinedTest {
    @TestFactory
    fun `combined API matches reference HP damage KO counts and final states`(): List<DynamicTest> {
        val cases = dartCombinedCases()
        assertEquals(810, cases.size)
        return cases.map { case ->
            dynamicTest(label(case)) { verifyCase(case) }
        }
    }

    @TestFactory
    fun `combined item and ability cases differ from their controls`(): List<DynamicTest> {
        val cases = dartCombinedCases()
        return listOf("ItemId", "AbilityId").flatMap { kind ->
            fun id(case: DartCombinedCase) = if (kind == "ItemId") case.item else case.ability

            fun key(case: DartCombinedCase) =
                ControlKey(
                    case.accuracy,
                    if (kind == "ItemId") case.ability else case.item,
                    case.status,
                    case.hazards,
                )
            val controls = cases.filter { id(it) == null }.associateBy(::key)
            val groups = cases.groupBy(::id)
            val ids =
                if (kind == "ItemId") {
                    setOf(null, "SitrusBerry", "Leftovers", "Heavy-DutyBoots", "SafetyGoggles")
                } else {
                    setOf(
                        null,
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
            groups.map { (id, rows) ->
                dynamicTest("$kind/${id ?: "none"}/control") {
                    assertEquals(if (kind == "ItemId") 162 else 90, rows.size)
                    val results = rows.map { it to verifyCase(it) }
                    val changedHp =
                        results.any { (case, result) ->
                            result.finalHp.weights != controls.getValue(key(case)).hp
                        }
                    val consumed =
                        results.any { (_, result) ->
                            result.finalStates.any { it.state.itemConsumed }
                        }
                    assertEquals(
                        id != null,
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

    private data class ControlKey(
        val accuracy: Int,
        val otherEffect: String?,
        val status: Status?,
        val hazards: Boolean,
    )

    private fun label(case: DartCombinedCase) =
        "accuracy=${case.accuracy}/ability=${case.ability}/item=${case.item}/" +
            "status=${case.status}/hazards=${case.hazards}"

    private fun verifyCase(case: DartCombinedCase): CombinedDamageResult {
        val label = label(case)
        val defender =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(100, 100, 100, 100, 100, 100),
                ability = case.ability?.let(::AbilityId),
                item = case.item?.let(::ItemId),
                status = case.status,
                toxicCounter = if (case.status == Status.TOXIC) ToxicCounter(1) else null,
            )
        val hazards = case.hazards
        val request =
            CombinedDamageRequest.repeatSingleHit(
                DamageDistribution.fromRolls(listOf(20, 40, 40)),
                defender,
                DamageDistribution.fromRolls(listOf(30, 60)),
                case.accuracy,
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
        assertEquals(case.hp, result.finalHp.weights, "$label HP")
        assertEquals(case.damage, result.attackDamage.weights, "$label damage")
        assertEquals(
            KoInfo(case.koStatus, 4, case.possible, case.guaranteed),
            result.ko,
            "$label KO",
        )
        val states =
            result.finalStates.map { entry ->
                with(entry.state) {
                    ExpectedCombinedState(
                        currentHp,
                        itemConsumed,
                        toxicCounter?.value,
                        cudChewTurn,
                        entry.weight,
                    )
                }
            }
        assertEquals(
            case.states.groupingBy { it }.eachCount(),
            states.groupingBy { it }.eachCount(),
            "$label states",
        )
        assertEquals(
            ExactProbability(
                case.hp[BigInteger.ZERO] ?: BigInteger.ZERO,
                case.hp.values.reduce(BigInteger::add),
            ),
            result.knockout,
            "$label knockout probability",
        )
        return result
    }
}
