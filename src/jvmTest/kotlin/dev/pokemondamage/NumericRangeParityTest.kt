package dev.pokemondamage

import dev.pokemondamage.engine.combined.BattleProgress
import dev.pokemondamage.engine.combined.CalculationBudget
import dev.pokemondamage.engine.combined.HealthEvents
import dev.pokemondamage.engine.combined.TurnEnd
import dev.pokemondamage.fixtures.wideHitIndexCases
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.math.toBigInteger
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CalculationLimits
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertTrue

class NumericRangeParityTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(100, 100, 100, 100, 100, 100),
        )

    @Test
    fun `Cud Chew schedule preserves signed 64 bit source values through combined calculation`() {
        for (
        turn in
        listOf(
            Long.MIN_VALUE,
            Int.MIN_VALUE.toLong() - 1,
            Int.MAX_VALUE.toLong() + 1,
            Long.MAX_VALUE,
        )
        ) {
            val defender =
                pokemon.copy(
                    ability = AbilityId("CudChew"),
                    item = ItemId("SitrusBerry"),
                    itemConsumed = true,
                    cudChewTurn = turn,
                )
            val request =
                CombinedDamageRequest.repeatSingleHit(
                    DamageDistribution.fromRolls(listOf(0)),
                    defender,
                )
            val result =
                assertIs<Calculation.Success<CombinedDamageResult>>(
                    calculateCombinedDamage(request),
                ).value
            assertEquals(mapOf(100.toBigInteger() to BigInteger.ONE), result.finalHp.weights)
            assertEquals(mapOf(BigInteger.ZERO to BigInteger.ONE), result.attackDamage.weights)
            val state = result.finalStates.single().state
            assertEquals(turn, state.cudChewTurn)
            assertTrue(state.itemConsumed)
            assertEquals(turn, state.initialPokemon.cudChewTurn)
        }
    }

    @Test
    fun `state limit accepts 64 bit values without truncating budget comparisons`() {
        for (limit in listOf(Int.MAX_VALUE.toLong() + 1, Long.MAX_VALUE)) {
            val limits = CalculationLimits(maxStates = limit)
            assertEquals(limit, limits.maxStates)
            assertTrue(CalculationBudget(limits).spend(1, Int.MAX_VALUE))
            val request =
                CombinedDamageRequest(
                    pokemon,
                    listOf(
                        Attack.fromAccuracy(1, listOf(DamageDistribution.fromRolls(listOf(10)))),
                    ),
                    limits = limits,
                )
            val result =
                assertIs<Calculation.Success<CombinedDamageResult>>(
                    calculateCombinedDamage(request),
                ).value
            assertEquals(mapOf(90.toBigInteger() to BigInteger.ONE), result.finalHp.weights)
        }
        assertFalse(
            CalculationBudget(CalculationLimits(maxStates = Int.MAX_VALUE.toLong() - 1))
                .spend(1, Int.MAX_VALUE),
        )
    }

    @Test
    fun `Attack accepts Long turns and combined sequences require consecutive turns from one`() {
        val hits = listOf(DamageDistribution.fromRolls(listOf(10)))
        for (turn in listOf(Int.MAX_VALUE.toLong() + 1, Long.MAX_VALUE)) {
            val attack = Attack.fromAccuracy(turn, hits)
            assertEquals(turn, attack.turn)
            assertEquals(
                attack,
                Attack(turn, hits, mapOf(1 to BigInteger.ONE), mapOf(1 to BigInteger.ONE)),
            )
            assertFailsWith<IllegalArgumentException> {
                CombinedDamageRequest(pokemon, listOf(attack))
            }
            assertFailsWith<IllegalArgumentException> {
                CombinedDamageRequest(pokemon, listOf(Attack.fromAccuracy(1, hits), attack))
            }
        }
        for (turn in listOf(0L, -1L, Long.MIN_VALUE)) {
            assertFailsWith<IllegalArgumentException> { Attack.fromAccuracy(turn, hits) }
        }
    }

    @Test
    fun `Cud Chew schedules and activates after a turn beyond 32 bit range`() {
        val defender = pokemon.copy(ability = AbilityId("CudChew"), item = ItemId("SitrusBerry"))
        val turn = Int.MAX_VALUE.toLong() + 1
        val consumed =
            HealthEvents(defender, BattleField())
                .damage(BattleProgress(100, false, null, null), 50.toBigInteger(), turn)
        assertEquals(75, consumed.hp)
        assertEquals(turn + 1, consumed.cudChewTurn)
        assertTrue(consumed.itemConsumed)
        val healed = TurnEnd(defender, BattleField()).apply(consumed, turn + 1)
        assertEquals(100, healed.hp)
        assertNull(healed.cudChewTurn)
    }

    @Test
    fun `wide hit indices reproduce native Dart power overflow and final damage`() {
        val rows =
            wideHitIndexCases()
        assertEquals(36, rows.size)
        assertEquals(setOf("TripleAxel", "TripleKick"), rows.map { it.move }.toSet())
        assertEquals(Long.MAX_VALUE, rows.maxOf { it.hitIndex })
        val combatant = pokemon.copy(stats = Stats(200, 100, 100, 100, 100, 100))
        for (c in rows) {
            val attacker =
                combatant.copy(
                    ability = if (c.technician) AbilityId("Technician") else null,
                )
            val request =
                DamageRequest(
                    attacker,
                    combatant,
                    Move(MoveId(c.move), PokemonType.NORMAL, c.power, Category.PHYSICAL),
                    hitIndex = c.hitIndex,
                )
            val result =
                assertIs<Calculation.Success<DamageResult>>(calculateDamage(request)).value.hit
            val label = c.toString()
            assertEquals(
                c.basePower,
                result.trace.first { it.stage == ModifierStage.BASE_POWER }.after,
                "$label base power",
            )
            assertEquals(c.finalPower, result.power, "$label final power")
            assertEquals(c.damage, result.rolls, "$label damage")
        }
        assertFailsWith<IllegalArgumentException> {
            DamageRequest(
                pokemon,
                pokemon,
                Move(MoveId("Tackle"), PokemonType.NORMAL, 40, Category.PHYSICAL),
                hitIndex = Long.MIN_VALUE,
            )
        }
    }
}
