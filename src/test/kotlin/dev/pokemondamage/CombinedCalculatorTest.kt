package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.AccuracyMode
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.BattleSetup
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CalculationLimits
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.FailureKind
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.KoCategory
import dev.pokemondamage.model.KoInfo
import dev.pokemondamage.model.KoStatus
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.ToxicCounter
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class CombinedCalculatorTest {
    private val one = BigInteger.ONE
    private val defender =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(100, 100, 100, 100, 100, 100),
        )

    private fun hit(vararg rolls: Int) = DamageDistribution.fromRolls(rolls.toList())

    private fun attack(
        turn: Int,
        vararg rolls: Int,
        accuracy: Int = 100,
    ) = Attack.fromAccuracy(turn.toLong(), listOf(hit(*rolls)), accuracy)

    private fun result(request: CombinedDamageRequest) =
        assertIs<Calculation.Success<CombinedDamageResult>>(calculateCombinedDamage(request)).value

    private fun weights(vararg pairs: Pair<Int, Int>) =
        pairs.associate {
            it.first.toBigInteger() to it.second.toBigInteger()
        }

    @Test
    fun `combined calculator preserves accuracy damage HP and conditional KO counts`() {
        val r =
            result(
                CombinedDamageRequest.repeatSingleHit(hit(40, 60), defender, accuracyPercent = 50),
            )
        assertEquals(100, r.referenceHp)
        assertEquals(BigInteger.ZERO, r.min)
        assertEquals(140.toBigInteger(), r.max)
        assertEquals(16.toBigInteger(), r.attackDamage.weights[BigInteger.ZERO])
        assertEquals(256.toBigInteger(), r.finalHp.totalWeight)
        assertEquals(7, r.finalStates.size)
        assertEquals(152.toBigInteger(), r.knockout.weight)
        assertEquals(0.59375, r.knockout.probability)
        assertEquals(
            weights(0 to 16, 40 to 32, 60 to 32, 80 to 24, 100 to 88, 120 to 54, 140 to 10),
            r.attackDamage.weights,
        )
        assertFalse(r.knockout.guaranteed)
        assertEquals(KoInfo(KoStatus.RESOLVED, 4, 2, 3), r.ko)
        assertEquals(KoCategory.THREE_HITS, r.ko.category)
        assertEquals(4, r.ko.evaluatedAttacks)
        assertEquals(r.finalHp.totalWeight, r.finalStates.map { it.weight }.reduce(BigInteger::add))
        assertTrue(r.finalStates.all { it.state.initialPokemon === defender })
        assertFailsWith<UnsupportedOperationException> { (r.finalStates as MutableList).clear() }
    }

    @Test
    fun `zero accuracy can still have a resolved conditional KO count`() {
        val r =
            result(CombinedDamageRequest.repeatSingleHit(hit(100), defender, accuracyPercent = 0))
        assertEquals(weights(100 to 1), r.finalHp.weights)
        assertEquals(weights(0 to 1), r.attackDamage.weights)
        assertEquals(0.0, r.knockout.probability)
        assertEquals(KoInfo(KoStatus.RESOLVED, 4, 1, 1), r.ko)
    }

    @Test
    fun `same-turn attacks apply residuals only after the last attack of that turn`() {
        val p = defender.copy(item = ItemId("Leftovers"))
        val sameTurn = result(CombinedDamageRequest(p, listOf(attack(1, 50), attack(1, 50))))
        assertTrue(sameTurn.knockout.guaranteed)
        assertEquals(KoInfo(KoStatus.RESOLVED, 2, 2, 2), sameTurn.ko)
        val separate = result(CombinedDamageRequest(p, listOf(attack(1, 50), attack(2, 50))))
        assertEquals(weights(12 to 1), separate.finalHp.weights)
        assertEquals(KoCategory.UNDETERMINED, separate.ko.category)
        assertNull(separate.ko.possibleHits)
    }

    @Test
    fun `setup KO is counted before attacks and excludes chip from attack damage`() {
        val r =
            result(
                CombinedDamageRequest.repeatSingleHit(
                    hit(1000),
                    defender,
                    setup = BattleSetup(initialDamages = listOf(100.toBigInteger())),
                ),
            )
        assertTrue(r.knockout.guaranteed)
        assertEquals(weights(0 to 1), r.attackDamage.weights)
        assertEquals(KoInfo(KoStatus.RESOLVED, 4, 0, 0), r.ko)
        assertEquals(KoCategory.ALREADY_KNOCKED_OUT, r.ko.category)
    }

    @Test
    fun `missing conditional counts disable KO count and preserve actual probability`() {
        val attack = Attack(1, listOf(hit(100)), mapOf(0 to one, 1 to one))
        val r = result(CombinedDamageRequest(defender, listOf(attack)))
        assertEquals(weights(0 to 1, 100 to 1), r.finalHp.weights)
        assertEquals(0.5, r.knockout.probability)
        assertEquals(KoInfo(KoStatus.NOT_APPLICABLE, 1), r.ko)
        assertEquals(KoCategory.NOT_APPLICABLE, r.ko.category)
        val perHit =
            Attack.fromAccuracy(
                1,
                listOf(hit(50), hit(50)),
                50,
                mapOf(2 to one),
                AccuracyMode.UNTIL_FIRST_MISS,
            )
        val multi = result(CombinedDamageRequest(defender, listOf(perHit)))
        assertEquals(0.25, multi.knockout.probability)
        assertEquals(KoStatus.NOT_APPLICABLE, multi.ko.status)
    }

    @Test
    fun `possible KO remains recorded while guarantee is unresolved`() {
        val r =
            result(CombinedDamageRequest(defender, listOf(attack(1, 0, 100), attack(1, 0, 100))))
        assertEquals(1, r.ko.possibleHits)
        assertNull(r.ko.guaranteedHits)
        assertEquals(KoCategory.UNDETERMINED, r.ko.category)
        assertEquals(0.75, r.knockout.probability)
        val four = result(CombinedDamageRequest.repeatSingleHit(hit(0), defender))
        assertEquals(KoCategory.FIVE_OR_MORE, four.ko.category)
    }

    @Test
    fun `different hit-count supports separate conditional outcomes even with equal cardinality`() {
        val a = Attack(1, listOf(hit(50)), mapOf(0 to one), mapOf(1 to one))
        val r =
            result(
                CombinedDamageRequest(
                    defender,
                    listOf(a, Attack(2, a.hits, a.hitCounts, a.conditionalHitCounts)),
                ),
            )
        assertEquals(KoInfo(KoStatus.RESOLVED, 2, 2, 2), r.ko)
        assertEquals(weights(100 to 1), r.finalHp.weights)
    }

    @Test
    fun `equal support shares reachability and preserves distinct weights`() {
        val a =
            Attack(
                1,
                listOf(hit(25), hit(25)),
                mapOf(1 to one, 2 to 3.toBigInteger()),
                mapOf(1 to 8.toBigInteger(), 2 to one),
            )
        val r = result(CombinedDamageRequest(defender, listOf(a)))
        assertEquals(weights(75 to 1, 50 to 3), r.finalHp.weights)
        assertNull(r.ko.possibleHits)
    }

    @Test
    fun `toxic rounding preserves survival and delays berry consumption`() {
        val p =
            defender.copy(
                stats = defender.stats.copy(hp = 175),
                status = Status.TOXIC,
                toxicCounter = ToxicCounter(2),
            )
        val surviving = result(CombinedDamageRequest(p, listOf(attack(1, 154))))
        assertEquals(weights(1 to 1), surviving.finalHp.weights)
        assertEquals(0.0, surviving.knockout.probability)
        assertNull(surviving.ko.possibleHits)
        val berry =
            result(
                CombinedDamageRequest(p.copy(item = ItemId("SitrusBerry")), listOf(attack(1, 67))),
            )
        assertEquals(weights(88 to 1), berry.finalHp.weights)
        val finalState = berry.finalStates.single().state
        assertFalse(finalState.itemConsumed)
        assertEquals(3, finalState.toxicCounter?.value)
    }

    @Test
    fun `final snapshots retain toxicity item consumption reservation and original metadata`() {
        val p =
            defender.copy(
                item = ItemId("SitrusBerry"),
                ability = AbilityId("CudChew"),
                status = Status.TOXIC,
                toxicCounter = ToxicCounter(1),
                cudChewTurn = 9,
            )
        val r = result(CombinedDamageRequest(p, listOf(attack(1, 50))))
        val s = r.finalStates.single().state
        assertEquals(69, s.currentHp) // 100 - 50 + 25 - 6.
        assertTrue(s.itemConsumed)
        assertEquals(2, s.toxicCounter?.value)
        assertEquals(2L, s.cudChewTurn)
        assertSame(p, s.initialPokemon)
        assertEquals(one, r.finalStates.single().weight)
    }

    @Test
    fun `post-damage recovery merges branches with different prior HP but matching histories`() {
        // 1発ごとの条件付き計算では攻撃ダメージ合計を除外し、回復で同じHPになった分岐を統合する。
        val p = defender.copy(ability = AbilityId("PoisonHeal"), status = Status.POISON)
        val r =
            result(
                CombinedDamageRequest(
                    p,
                    listOf(attack(1, 1, 2, accuracy = 50), attack(2, 100, accuracy = 50)),
                ),
            )
        assertEquals(0.5, r.knockout.probability)
        assertEquals(KoInfo(KoStatus.RESOLVED, 2, 2, 2), r.ko)
    }

    @Test
    fun `complexity budget covers input convolution conditional work and final accounting`() {
        val request =
            CombinedDamageRequest.repeatSingleHit(hit(10, 20), defender, accuracyPercent = 50)
        val firstSuccess =
            (1..500).firstOrNull { operations ->
                val r =
                    calculateCombinedDamage(
                        CombinedDamageRequest(
                            defender,
                            request.attacks,
                            limits = CalculationLimits(operations.toLong(), 1000),
                        ),
                    )
                if (r is Calculation.Success) {
                    return@firstOrNull true
                }
                assertEquals(
                    Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "distribution"),
                    r,
                )
                false
            }
        assertNotNull(firstSuccess)
        assertTrue(firstSuccess > 30)
        assertEquals(
            Calculation.Failure(FailureKind.COMPLEXITY_EXCEEDED, "distribution"),
            calculateCombinedDamage(
                CombinedDamageRequest(
                    defender,
                    listOf(attack(1, 1, 2)),
                    limits = CalculationLimits(maxStates = 1),
                ),
            ),
        )
    }

    @Test
    fun `KO display categories count attacks and distinguish unresolved from inapplicable`() {
        val categories =
            listOf(
                KoCategory.ALREADY_KNOCKED_OUT,
                KoCategory.ONE_HIT,
                KoCategory.TWO_HITS,
                KoCategory.THREE_HITS,
                KoCategory.FOUR_HITS,
                KoCategory.FIVE_OR_MORE,
            )
        for ((count, category) in categories.withIndex()) {
            assertEquals(
                category,
                KoInfo(KoStatus.RESOLVED, 5, count, count).category,
            )
        }
        assertEquals(KoCategory.FIVE_OR_MORE, KoInfo(KoStatus.LIMIT_REACHED, 4).category)
        assertEquals(KoCategory.UNDETERMINED, KoInfo(KoStatus.LIMIT_REACHED, 3).category)
        assertEquals(KoCategory.NOT_APPLICABLE, KoInfo(KoStatus.NOT_APPLICABLE, 4).category)
    }
}
