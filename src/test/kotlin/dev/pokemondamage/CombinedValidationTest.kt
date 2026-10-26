package dev.pokemondamage

import dev.pokemondamage.model.AccuracyMode
import dev.pokemondamage.model.Attack
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.DamageDistribution
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Validation
import dev.pokemondamage.model.ValidationCode
import dev.pokemondamage.model.ValidationError
import dev.pokemondamage.model.validate
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class CombinedValidationTest {
    private val one = BigInteger.ONE
    private val hit = DamageDistribution.fromRolls(listOf(20))

    private fun range(path: String) = ValidationError(path, ValidationCode.OUT_OF_RANGE)

    private fun required(path: String) = ValidationError(path, ValidationCode.REQUIRED)

    @Test
    fun `distribution reports every invalid damage and weight in sorted key order`() {
        val result =
            validate("hit") {
                DamageDistribution(linkedMapOf(one to -one, -one to BigInteger.ZERO))
            }
        assertEquals(
            listOf(
                range("hit.weights[-1].damage"),
                range("hit.weights[-1].weight"),
                range("hit.weights[1].weight"),
            ),
            assertIs<Validation.Invalid>(result).errors,
        )
        assertEquals(
            listOf(required("weights")),
            assertIs<Validation.Invalid>(validate { DamageDistribution(emptyMap()) }).errors,
        )
        assertEquals(
            listOf(range("hp")),
            assertIs<Validation.Invalid>(validate { hit.knockoutProbability(-one) }).errors,
        )
    }

    @Test
    fun `attack collects turn and both count distribution errors without stopping early`() {
        val result =
            validate("attacks[2]") {
                Attack(0, listOf(hit), mapOf(-1 to -one, 2 to BigInteger.ZERO), mapOf(0 to -one))
            }
        assertEquals(
            listOf(
                range("attacks[2].turn"),
                range("attacks[2].hitCounts[-1]"),
                range("attacks[2].hitCounts[-1].weight"),
                range("attacks[2].hitCounts[2]"),
                range("attacks[2].hitCounts[2].weight"),
                range("attacks[2].conditionalHitCounts[0]"),
                range("attacks[2].conditionalHitCounts[0].weight"),
            ),
            assertIs<Validation.Invalid>(result).errors,
        )
        val empty = validate { Attack(1, emptyList(), emptyMap(), emptyMap()) }
        assertEquals(
            listOf(required("hits"), required("hitCounts"), required("conditionalHitCounts")),
            assertIs<Validation.Invalid>(empty).errors,
        )
    }

    @Test
    fun `accuracy factory rejects all invalid inputs before arithmetic`() {
        val result =
            validate {
                Attack.fromAccuracy(
                    0,
                    emptyList(),
                    101,
                    mapOf(1 to BigInteger.ZERO),
                    AccuracyMode.UNTIL_FIRST_MISS,
                )
            }
        assertEquals(
            listOf(
                range("turn"),
                required("hits"),
                range("accuracyPercent"),
                range("hitCountWeights[1]"),
                range("hitCountWeights[1].weight"),
            ),
            assertIs<Validation.Invalid>(result).errors,
        )
    }

    @Test
    fun `combined request reports each invalid attack turn by index`() {
        val defender =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(100, 100, 100, 100, 100, 100),
            )
        val result =
            validate {
                CombinedDamageRequest(
                    defender,
                    listOf(2L, 4L, 1L).map { Attack.fromAccuracy(it, listOf(hit)) },
                )
            }
        assertEquals(
            (0..2).map { ValidationError("attacks[$it].turn", ValidationCode.INCONSISTENT) },
            assertIs<Validation.Invalid>(result).errors,
        )
        val empty = validate { CombinedDamageRequest(defender, emptyList()) }
        assertEquals(listOf(required("attacks")), assertIs<Validation.Invalid>(empty).errors)
    }
}
