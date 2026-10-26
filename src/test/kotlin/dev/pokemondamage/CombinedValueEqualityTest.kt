package dev.pokemondamage

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
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

class CombinedValueEqualityTest {
    private val one = BigInteger.ONE
    private val hit = DamageDistribution.fromRolls(listOf(20, 40))
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(100, 100, 100, 100, 100, 100),
        )

    private fun assertValueContract(
        value: Any,
        equalValue: Any,
        differences: List<Any>,
    ) {
        assertEquals(value, value)
        assertEquals(value, equalValue)
        assertEquals(equalValue, value)
        assertEquals(value.hashCode(), equalValue.hashCode())
        assertEquals(1, setOf(value, equalValue).size)
        assertEquals("cached", mapOf(value to "cached")[equalValue])
        assertFalse(value.equals(null))
        assertFalse(value.equals("unrelated"))
        for (different in differences) {
            assertNotEquals(value, different)
            assertNotEquals(different, value)
        }
    }

    @Test
    fun `Attack structural equality includes turn hits count weights and conditional weights`() {
        val value = Attack(1, listOf(hit), mapOf(0 to one, 1 to one), mapOf(1 to one))
        assertValueContract(
            value,
            Attack(
                1,
                listOf(DamageDistribution.fromRolls(listOf(40, 20))),
                linkedMapOf(1 to one, 0 to one),
                mapOf(1 to one),
            ),
            listOf(
                Attack(2, listOf(hit), value.hitCounts, value.conditionalHitCounts),
                Attack(
                    1,
                    listOf(DamageDistribution.fromRolls(listOf(20))),
                    value.hitCounts,
                    value.conditionalHitCounts,
                ),
                Attack(1, listOf(hit), mapOf(1 to one), value.conditionalHitCounts),
                Attack(1, listOf(hit), value.hitCounts, null),
            ),
        )
        assertValueContract(
            Attack(1, listOf(hit), mapOf(1 to one)),
            Attack(1, listOf(hit), mapOf(1 to one)),
            emptyList(),
        )
    }

    @Test
    fun `BattleSetup equality includes ordered damage and hazards with stable hashing`() {
        val input = mutableListOf(one, BigInteger.TWO)
        val value = BattleSetup(EntryHazards(true, Spikes.TWO_LAYERS), input)
        val hash = value.hashCode()
        input.clear()
        assertEquals(hash, value.hashCode())
        assertValueContract(
            value,
            BattleSetup(EntryHazards(true, Spikes.TWO_LAYERS), listOf(one, BigInteger.TWO)),
            listOf(
                BattleSetup(EntryHazards(false, Spikes.TWO_LAYERS), value.initialDamages),
                BattleSetup(value.entryHazards, listOf(BigInteger.TWO, one)),
            ),
        )
    }

    @Test
    fun `CombinedDamageRequest structural equality includes all five request components`() {
        fun request(
            defender: PokemonState = pokemon,
            attacks: List<Attack> = listOf(Attack.fromAccuracy(1, listOf(hit))),
            field: BattleField = BattleField(),
            setup: BattleSetup = BattleSetup(),
            limits: CalculationLimits = CalculationLimits(),
        ) = CombinedDamageRequest(defender, attacks, field, setup, limits)
        assertValueContract(
            request(),
            request(),
            listOf(
                request(defender = pokemon.copy(currentHp = 50)),
                request(attacks = listOf(Attack.fromAccuracy(1, listOf(hit), 50))),
                request(field = BattleField(weather = Weather.SANDSTORM)),
                request(setup = BattleSetup(initialDamages = listOf(one))),
                request(limits = CalculationLimits(maxStates = 1)),
            ),
        )
    }
}
