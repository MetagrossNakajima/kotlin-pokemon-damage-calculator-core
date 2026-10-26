package dev.pokemondamage

import dev.pokemondamage.engine.combined.*
import dev.pokemondamage.model.*
import java.math.BigInteger
import kotlin.test.*

class AttackConvolutionTest {
    private val one = BigInteger.ONE
    private val defender =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(100, 100, 100, 100, 100, 100),
        )
    private val state = BattleProgress(100, false, null, null)

    private fun counts(vararg entries: Pair<Int, Int>) = entries.associate {
        it.first to it.second.toBigInteger()
    }

    private fun distribution(vararg entries: Pair<Int, Int>) =
        DamageDistribution(
            entries.associate { it.first.toBigInteger() to it.second.toBigInteger() },
        )

    private fun engine(
        p: PokemonState = defender,
        limits: CalculationLimits = CalculationLimits(),
    ) = AttackConvolution(HealthEvents(p, BattleField()), CalculationBudget(limits))

    private fun success(result: Calculation<AttackOutcomes>) =
        assertIs<Calculation.Success<AttackOutcomes>>(result).value

    @Test
    fun `prefix scaling combines misses and unequal hit denominators exactly`() {
        val attack =
            Attack(
                1,
                listOf(distribution(10 to 1, 20 to 1), distribution(30 to 1, 40 to 2)),
                counts(0 to 1, 1 to 2, 2 to 1),
            )
        val r = success(engine().apply(mapOf(state to one), attack))
        assertNull(r.conditional)
        val damageWeights = r.actual.entries.associate { it.key.attackDamage.toInt() to it.value }
        assertEquals(counts(0 to 6, 10 to 6, 20 to 6, 40 to 1, 50 to 3, 60 to 2), damageWeights)
        assertEquals(24.toBigInteger(), r.actual.values.reduce(BigInteger::add))
        assertEquals(setOf(100, 90, 80, 60, 50, 40), r.actual.keys.map { it.hp }.toSet())
    }

    @Test
    fun `KO stops further damage but retains unused roll weight`() {
        val attack =
            Attack(
                1,
                listOf(distribution(100 to 1, 120 to 2), distribution(1 to 1, 999 to 4)),
                counts(2 to 1),
            )
        val r = success(engine().apply(mapOf(state to one), attack))
        assertEquals(
            mapOf(
                state.copy(hp = 0, attackDamage = 100.toBigInteger()) to 5.toBigInteger(),
                state.copy(hp = 0, attackDamage = 120.toBigInteger()) to 10.toBigInteger(),
            ),
            r.actual,
        )
    }

    @Test
    fun `shared conditional outcomes retain possible hits even when accuracy is zero`() {
        val attack = Attack.fromAccuracy(1, listOf(distribution(100 to 1)), 0)
        val r =
            success(
                engine()
                    .apply(
                        mapOf(state to one),
                        attack,
                        sharedConditionalCounts = attack.conditionalHitCounts,
                    ),
            )
        assertEquals(mapOf(state to one), r.actual)
        assertEquals(mapOf(state.copy(hp = 0) to one), r.conditional)
    }

    @Test
    fun `conditional collection merges histories and preserves state and exact weights`() {
        val attack = Attack(1, listOf(distribution(0 to 1)), counts(1 to 1))
        val branches =
            mapOf(
                state.copy(attackDamage = 10.toBigInteger()) to one,
                state.copy(attackDamage = 20.toBigInteger()) to 2.toBigInteger(),
            )
        val r = success(engine().apply(branches, attack, sharedConditionalCounts = counts(1 to 1)))
        assertEquals(branches, r.actual)
        assertEquals(mapOf(state to 3.toBigInteger()), r.conditional)
        val only = success(engine().apply(branches, attack, trackAttackDamage = false))
        assertEquals(mapOf(state to 3.toBigInteger()), only.actual)
        assertNull(only.conditional)
    }

    @Test
    fun `berry consumption between hits changes the surviving branch`() {
        val attack = Attack(1, List(2) { distribution(50 to 1, 60 to 1) }, counts(2 to 1))
        val r =
            success(
                engine(defender.copy(item = ItemId("SitrusBerry")))
                    .apply(mapOf(state to one), attack),
            )
        assertEquals(
            mapOf(
                state.copy(hp = 25, itemConsumed = true, attackDamage = 100.toBigInteger()) to one,
                state.copy(hp = 15, itemConsumed = true, attackDamage = 110.toBigInteger()) to
                    2.toBigInteger(),
                state.copy(hp = 5, itemConsumed = true, attackDamage = 120.toBigInteger()) to one,
            ),
            r.actual,
        )
    }

    @Test
    fun `existing fainted branches merge with newly fainted conditional branches`() {
        val attack = Attack(1, listOf(distribution(1 to 2)), counts(1 to 1))
        val branches = linkedMapOf(state.copy(hp = 1) to one, state.copy(hp = 0) to one)
        val result = success(engine().apply(branches, attack, trackAttackDamage = false))
        assertEquals(mapOf(state.copy(hp = 0) to 4.toBigInteger()), result.actual)
    }

    @Test
    fun `miss-only attacks do not execute provided hits`() {
        val attack = Attack(1, listOf(distribution(999 to 1)), counts(0 to 1))
        assertEquals(
            mapOf(state to one),
            success(engine().apply(mapOf(state to one), attack)).actual,
        )
    }

    @Test
    fun `limits fail during prefix collection alive expansion and fainted weight propagation`() {
        val failure = Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "distribution")
        val two = Attack(1, listOf(distribution(10 to 1, 20 to 1)), counts(1 to 1))
        assertEquals(
            failure,
            engine(limits = CalculationLimits(maxStates = 1)).apply(mapOf(state to one), two),
        )
        assertEquals(
            failure,
            engine(limits = CalculationLimits(maxOperations = 2)).apply(mapOf(state to one), two),
        )
        val misses = Attack(1, listOf(distribution(10 to 1)), counts(0 to 1, 1 to 1))
        assertEquals(
            failure,
            engine(limits = CalculationLimits(maxOperations = 1))
                .apply(mapOf(state.copy(hp = 0) to one), misses),
        )
        assertEquals(
            failure,
            engine(limits = CalculationLimits(maxOperations = 2))
                .apply(
                    mapOf(state to one),
                    Attack(1, misses.hits, counts(0 to 1)),
                    sharedConditionalCounts = counts(1 to 1),
                ),
        )
        val branches = mapOf(state to one, state.copy(hp = 99) to one)
        val missOnly = Attack(1, listOf(distribution(1 to 1)), counts(0 to 1))
        assertEquals(
            failure,
            engine(limits = CalculationLimits(maxOperations = 1)).apply(branches, missOnly),
        )
    }

    @Test
    fun `budget accumulates work and compares without overflowing Long`() {
        val budget = CalculationBudget(CalculationLimits(5, 2))
        assertTrue(budget.spend(2, 2))
        assertFalse(budget.spend(4, 1))
        assertFalse(budget.spend(1, 3))
        assertTrue(budget.spend(3, 2))
        assertFalse(budget.spend(1, 1))
        val huge = CalculationBudget(CalculationLimits(Long.MAX_VALUE, 1))
        assertTrue(huge.spend(Long.MAX_VALUE, 1))
        assertFalse(huge.spend(Long.MAX_VALUE, 1))
    }
}
