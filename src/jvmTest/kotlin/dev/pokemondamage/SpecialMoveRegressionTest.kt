package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.math.toBigInteger
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.ExactProbability
import dev.pokemondamage.model.HitResult
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Validation
import dev.pokemondamage.model.ValidationCode
import dev.pokemondamage.model.ValidationError
import dev.pokemondamage.model.validate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class SpecialMoveRegressionTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.PSYCHIC), PokemonWeight(40)),
            Stats(175, 100, 100, 100, 100, 100),
        )
    private val shellSideArm =
        Move(MoveId("ShellSideArm"), PokemonType.POISON, 90, Category.SPECIAL)

    private fun result(request: DamageRequest): DamageResult =
        assertIs<Calculation.Success<DamageResult>>(calculateDamage(request)).value

    @Test
    fun `Shell Side Arm ties mix physical and special damage with equal probability`() {
        val request =
            DamageRequest(pokemon, pokemon.copy(ability = AbilityId("IceScales")), shellSideArm)
        val calculated = result(request)
        assertEquals(
            listOf(17, 17, 17, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 20, 20, 20),
            calculated.hit.rolls,
        )
        assertEquals(
            listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            assertNotNull(calculated.alternativeHit).rolls,
        )
        assertEquals(17, calculated.min)
        assertEquals(41, calculated.max)
        assertEquals(41 * 100.0 / 175, calculated.maxPercent)
        assertEquals(
            ExactProbability(16.toBigInteger(), 32.toBigInteger()),
            calculated.distribution.knockoutProbability(30.toBigInteger()),
        )
        // 合成済み分布を連続計算に渡しても、1発目の撃破確率が保持される。
        val combined =
            assertIs<Calculation.Success<CombinedDamageResult>>(
                calculateCombinedDamage(
                    CombinedDamageRequest(
                        pokemon.copy(currentHp = 30),
                        listOf(
                            Attack.fromAccuracy(1, listOf(calculated.distribution)),
                        ),
                    ),
                ),
            ).value
        assertEquals(ExactProbability(16.toBigInteger(), 32.toBigInteger()), combined.knockout)
    }

    @Test
    fun `Shell Side Arm compares rounded damage before choosing a category`() {
        // A101/C100では交差積は異なるが、基礎ダメージは両方41になる。
        val roundedTie =
            DamageRequest(
                pokemon.copy(stats = pokemon.stats.copy(attack = 101)),
                pokemon,
                shellSideArm,
            )
        assertTrue(DamageContext(roundedTie).move.categoryTied)
        assertNotNull(result(roundedTie).alternativeHit)
        for ((attack, category) in listOf(102 to Category.PHYSICAL, 98 to Category.SPECIAL)) {
            val request =
                roundedTie.copy(
                    attacker = pokemon.copy(stats = pokemon.stats.copy(attack = attack)),
                )
            val context = DamageContext(request)
            assertEquals(category, context.move.category)
            assertEquals(category == Category.PHYSICAL, context.contact)
            assertFalse(context.move.categoryTied)
            assertNull(result(request).alternativeHit)
        }
    }

    @Test
    fun `Shell Side Arm physical alternative applies contact modifiers`() {
        val calculated =
            result(
                DamageRequest(pokemon, pokemon.copy(ability = AbilityId("Fluffy")), shellSideArm),
            )
        assertEquals(34, calculated.hit.rolls.min())
        assertEquals(41, calculated.hit.rolls.max())
        val physical = assertNotNull(calculated.alternativeHit)
        assertEquals(17, physical.rolls.min())
        assertEquals(20, physical.rolls.max())
        assertEquals(
            ExactProbability(16.toBigInteger(), 32.toBigInteger()),
            calculated.distribution.knockoutProbability(30.toBigInteger()),
        )
    }

    @Test
    fun `alternative distributions remain equiprobable with unequal roll counts`() {
        val first = HitResult(90, 100, 100, false, listOf(10), emptyList())
        val second = HitResult(90, 100, 100, false, listOf(10, 30), emptyList())
        val calculated = DamageResult(first, 100, second)
        assertEquals(
            mapOf(
                10.toBigInteger() to 3.toBigInteger(),
                30.toBigInteger() to BigInteger.ONE,
            ),
            calculated.distribution.weights,
        )
        assertEquals(
            ExactProbability(BigInteger.ONE, 4.toBigInteger()),
            calculated.distribution.knockoutProbability(20.toBigInteger()),
        )
    }

    @Test
    fun `Stored Power and Power Trip include positive accuracy and evasion stages`() {
        for (name in listOf("StoredPower", "PowerTrip")) {
            val physical = name == "PowerTrip"
            val move =
                Move(
                    MoveId(name),
                    if (physical) PokemonType.DARK else PokemonType.PSYCHIC,
                    20,
                    if (physical) Category.PHYSICAL else Category.SPECIAL,
                )
            for ((stages, power) in listOf(
                StatStages.fromValues(accuracy = 2) to 60,
                StatStages.fromValues(evasion = 2) to 60,
                StatStages.fromValues(attack = 1, accuracy = 2, evasion = 3) to 140,
                StatStages.fromValues(attack = 1, accuracy = -6, evasion = -2) to 40,
                StatStages.fromValues(6, 6, 6, 6, 6, 6, 6) to 860,
            )) {
                val calculated = result(DamageRequest(pokemon.copy(stages = stages), pokemon, move))
                assertEquals(power, calculated.hit.power, "$name/$stages")
                val stage = if (physical) stages.attack.value else stages.specialAttack.value
                val expectedAttack =
                    when (stage) {
                        6 -> 400
                        1 -> 150
                        else -> 100
                    }
                assertEquals(expectedAttack, calculated.hit.attack)
                assertNull(calculated.alternativeHit)
            }
        }
    }

    @Test
    fun `accuracy and evasion reject invalid ranks together`() {
        for ((accuracy, evasion) in listOf(-7 to 7, 7 to -7)) {
            val invalid =
                assertIs<Validation.Invalid>(
                    validate {
                        StatStages.fromValues(accuracy = accuracy, evasion = evasion)
                    },
                )
            assertEquals(
                listOf(
                    ValidationError("accuracy", ValidationCode.OUT_OF_RANGE),
                    ValidationError("evasion", ValidationCode.OUT_OF_RANGE),
                ),
                invalid.errors,
            )
        }
    }
}
