package dev.pokemondamage

import dev.pokemondamage.model.AccuracyMode
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleSetup
import dev.pokemondamage.model.CalculationLimits
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.EntryHazards
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Spikes
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Weather
import dev.pokemondamage.model.validate
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class CombinedInputTest {
    private val one = BigInteger.ONE
    private val hit = DamageDistribution.fromRolls(listOf(10, 20))
    private val defender =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun counts(vararg pairs: Pair<Int, Int>) =
        pairs.associate {
            it.first to it.second.toBigInteger()
        }

    @Test
    fun `accuracy and hit count weights combine exactly and preserve conditional counts`() {
        val attack = Attack.fromAccuracy(1, listOf(hit, hit, hit), 75, counts(2 to 1, 3 to 2))
        assertEquals(counts(0 to 1, 2 to 1, 3 to 2), attack.hitCounts)
        assertEquals(counts(2 to 1, 3 to 2), attack.conditionalHitCounts)
        assertEquals(counts(1 to 1), Attack.fromAccuracy(1, listOf(hit)).hitCounts)
        assertEquals(counts(0 to 1), Attack.fromAccuracy(1, listOf(hit), 0).hitCounts)
        assertEquals(counts(1 to 1), Attack.fromAccuracy(1, listOf(hit), 100).hitCounts)
        val huge = one.shiftLeft(150)
        assertEquals(
            counts(0 to 1, 1 to 1),
            Attack.fromAccuracy(1, listOf(hit), 50, mapOf(1 to huge)).hitCounts,
        )
    }

    @Test
    fun `independent accuracy stops on first miss and retains mixed-length probabilities`() {
        val a =
            Attack.fromAccuracy(
                1,
                List(3) { hit },
                50,
                counts(3 to 1),
                AccuracyMode.UNTIL_FIRST_MISS,
            )
        assertEquals(counts(0 to 4, 1 to 2, 2 to 1, 3 to 1), a.hitCounts)
        assertNull(a.conditionalHitCounts)
        val mixed =
            Attack.fromAccuracy(
                1,
                List(3) {
                    hit
                },
                50,
                counts(1 to 1, 3 to 1),
                AccuracyMode.UNTIL_FIRST_MISS,
            )
        assertEquals(counts(0 to 8, 1 to 6, 2 to 1, 3 to 1), mixed.hitCounts)
        assertEquals(
            counts(0 to 1),
            Attack
                .fromAccuracy(
                    1,
                    List(3) { hit },
                    0,
                    counts(3 to 1),
                    AccuracyMode.UNTIL_FIRST_MISS,
                ).hitCounts,
        )
        assertEquals(
            counts(3 to 1),
            Attack
                .fromAccuracy(
                    1,
                    List(3) {
                        hit
                    },
                    100,
                    counts(3 to 1),
                    AccuracyMode.UNTIL_FIRST_MISS,
                ).hitCounts,
        )
    }

    @Test
    fun `per-hit accuracy preserves unequal hit count weights on miss branches`() {
        // Select one hit with probability 1/3 or three hits with probability 2/3.
        // At 75% accuracy, P(0,1,2,3 hits) = (1/4,3/8,3/32,9/32).
        val attack =
            Attack.fromAccuracy(
                1,
                List(3) {
                    hit
                },
                75,
                counts(1 to 1, 3 to 2),
                AccuracyMode.UNTIL_FIRST_MISS,
            )
        assertEquals(counts(0 to 8, 1 to 12, 2 to 3, 3 to 9), attack.hitCounts)
        assertNull(attack.conditionalHitCounts)
    }

    @Test
    fun `attack snapshots lists maps and conditional weights`() {
        val hits = mutableListOf(hit)
        val weights = mutableMapOf(1 to one)
        val a = Attack(1, hits, weights, weights)
        hits.clear()
        weights.clear()
        assertEquals(listOf(hit), a.hits)
        assertEquals(counts(1 to 1), a.hitCounts)
        assertEquals(counts(1 to 1), a.conditionalHitCounts)
        assertFailsWith<UnsupportedOperationException> { (a.hits as MutableList).clear() }
        assertFailsWith<UnsupportedOperationException> { (a.hitCounts as MutableMap).clear() }
        assertFailsWith<UnsupportedOperationException> {
            (a.conditionalHitCounts as MutableMap).clear()
        }
    }

    @Test
    fun `attack rejects invalid turns empty hits and invalid count distributions`() {
        assertFailsWith<IllegalArgumentException> { Attack(0, listOf(hit), counts(1 to 1)) }
        assertFailsWith<IllegalArgumentException> { Attack(1, emptyList(), counts(0 to 1)) }
        for (
        weights in
        listOf(emptyMap(), counts(-1 to 1), counts(2 to 1), counts(1 to 0), counts(1 to -1))
        ) {
            assertFailsWith<IllegalArgumentException> { Attack(1, listOf(hit), weights) }
        }
        for (weights in listOf(emptyMap(), counts(0 to 1), counts(2 to 1), counts(1 to 0))) {
            assertFailsWith<IllegalArgumentException> {
                Attack(1, listOf(hit), counts(1 to 1), weights)
            }
            assertFailsWith<IllegalArgumentException> {
                Attack.fromAccuracy(1, listOf(hit), hitCountWeights = weights)
            }
        }
        for (accuracy in listOf(-1, 101)) {
            assertFailsWith<IllegalArgumentException> {
                Attack.fromAccuracy(1, listOf(hit), accuracy)
            }
        }
        assertEquals(counts(0 to 1), Attack(1, listOf(hit), counts(0 to 1)).hitCounts)
        assertEquals(Long.MAX_VALUE, Attack(Long.MAX_VALUE, listOf(hit), counts(1 to 1)).turn)
    }

    @Test
    fun `setup and limits validate boundaries and snapshot initial damages`() {
        for (layers in 0..3) {
            assertEquals(layers, EntryHazards(spikes = Spikes.fromLayers(layers)).spikes.layers)
        }
        assertTrue(EntryHazards(stealthRock = true).stealthRock)
        for (layers in listOf(-1, 4)) {
            assertFailsWith<IllegalArgumentException> {
                EntryHazards().copy(spikes = Spikes.fromLayers(layers))
            }
        }
        val damages = mutableListOf(BigInteger.ZERO, one.shiftLeft(100))
        val setup = BattleSetup(EntryHazards(true, Spikes.THREE_LAYERS), damages)
        damages.clear()
        assertEquals(listOf(BigInteger.ZERO, one.shiftLeft(100)), setup.initialDamages)
        assertEquals(EntryHazards(true, Spikes.THREE_LAYERS), setup.entryHazards)
        assertFailsWith<UnsupportedOperationException> {
            (setup.initialDamages as MutableList).clear()
        }
        assertFailsWith<IllegalArgumentException> { BattleSetup(initialDamages = listOf(-one)) }
        assertEquals(2_000_000L, CalculationLimits().maxOperations)
        assertEquals(100_000L, CalculationLimits().maxStates)
        assertEquals(
            Long.MAX_VALUE,
            CalculationLimits(Long.MAX_VALUE, Long.MAX_VALUE).maxOperations,
        )
        assertEquals(1L, CalculationLimits(1, 1).maxStates)
        for (bad in listOf(0, -1)) {
            assertFailsWith<IllegalArgumentException> {
                CalculationLimits().copy(maxOperations = bad.toLong())
            }
            assertFailsWith<IllegalArgumentException> {
                CalculationLimits().copy(maxStates = bad.toLong())
            }
        }
    }

    @Test
    fun `combined request requires contiguous ordered turns and snapshots attacks`() {
        fun attack(turn: Int) = Attack.fromAccuracy(turn.toLong(), listOf(hit))
        for (turns in listOf(listOf(1), listOf(1, 1, 2, 2, 3))) {
            val attacks = turns.map(::attack).toMutableList()
            val r = CombinedDamageRequest(defender, attacks)
            attacks.clear()
            assertEquals(turns.map(Int::toLong), r.attacks.map { it.turn })
            assertEquals(defender, r.defender)
            assertEquals(BattleField(), r.field)
            assertTrue(r.setup.initialDamages.isEmpty())
            assertEquals(CalculationLimits(), r.limits)
            assertFailsWith<UnsupportedOperationException> { (r.attacks as MutableList).clear() }
        }
        for (
        turns in
        listOf(
            emptyList(),
            listOf(2),
            listOf(1, 3),
            listOf(1, 2, 1),
            listOf(1, Int.MAX_VALUE),
        )
        ) {
            assertFailsWith<IllegalArgumentException> {
                CombinedDamageRequest(defender, turns.map(::attack))
            }
        }
    }

    @Test
    fun `four-turn helper preserves distributions and explicit accuracy overrides`() {
        val later = DamageDistribution.fromRolls(listOf(30))
        val field = BattleField(weather = Weather.RAIN)
        val setup = BattleSetup(EntryHazards(true, Spikes.TWO_LAYERS))
        val limits = CalculationLimits(10, 10)
        val r =
            CombinedDamageRequest.repeatSingleHit(
                hit,
                defender,
                later,
                75,
                field = field,
                setup = setup,
                limits = limits,
            )
        assertEquals(listOf(1L, 2L, 3L, 4L), r.attacks.map { it.turn })
        assertEquals(listOf(hit, later, later, later), r.attacks.map { it.hits.single() })
        assertTrue(
            r.attacks.all {
                it.hitCounts == counts(0 to 1, 1 to 3) && it.conditionalHitCounts == counts(1 to 1)
            },
        )
        assertEquals(field, r.field)
        assertSame(setup, r.setup)
        assertEquals(limits, r.limits)
        val repeat = CombinedDamageRequest.repeatSingleHit(hit, defender)
        assertEquals(List(4) { hit }, repeat.attacks.map { it.hits.single() })
        val overridden =
            CombinedDamageRequest.repeatSingleHit(
                hit,
                defender,
                accuracyPercent = -1,
                hitCounts = counts(0 to 2, 1 to 1),
            )
        assertTrue(
            overridden.attacks.all {
                it.hitCounts == counts(0 to 2, 1 to 1) && it.conditionalHitCounts == counts(1 to 1)
            },
        )
    }
}
