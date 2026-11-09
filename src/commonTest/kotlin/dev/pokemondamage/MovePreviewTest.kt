package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.FailureKind
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class MovePreviewTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(
                PokemonId("Pikachu"),
                PokemonTypes(PokemonType.ELECTRIC),
                PokemonWeight.fromKilograms(100.0),
            ),
            Stats(100, 100, 100, 100, 100, 100),
        )

    @Test
    fun weatherPreviewUsesSuppressionAndLeavesDamageInputUnchanged() {
        val move = Move(MoveId("WeatherBall"), PokemonType.NORMAL, 50, Category.SPECIAL)
        val request = DamageRequest(pokemon, pokemon, move, BattleField(weather = Weather.RAIN))
        val preview = assertIs<Calculation.Success<MovePreview>>(previewMove(request)).value
        assertEquals(TeraType.WATER, preview.type)
        assertEquals(100L, preview.power)
        assertEquals(Category.SPECIAL, preview.category)
        assertEquals(50, request.move.power)
        assertEquals(
            100,
            assertIs<Calculation.Success<dev.pokemondamage.model.DamageResult>>(
                calculateDamage(request),
            ).value.hit.power,
        )
        val suppressed = request.copy(defender = pokemon.copy(ability = AbilityId("CloudNine")))
        val plain = assertIs<Calculation.Success<MovePreview>>(previewMove(suppressed)).value
        assertEquals(TeraType.NORMAL, plain.type)
        assertEquals(50L, plain.power)
    }

    @Test
    fun weightPreviewUsesAbilityAndItemBeforeThresholds() {
        val move = Move(MoveId("LowKick"), PokemonType.FIGHTING, 1, Category.PHYSICAL)
        for ((target, power) in listOf(
            pokemon to 100L,
            pokemon.copy(ability = AbilityId("HeavyMetal")) to 120L,
            pokemon.copy(ability = AbilityId("HeavyMetal"), item = ItemId("FloatStone")) to 100L,
        )) {
            val request = DamageRequest(pokemon, target, move)
            val preview = assertIs<Calculation.Success<MovePreview>>(previewMove(request)).value
            assertEquals(power, preview.power)
            assertEquals(Category.PHYSICAL, preview.category)
            assertEquals(
                power.toInt(),
                assertIs<Calculation.Success<dev.pokemondamage.model.DamageResult>>(
                    calculateDamage(request),
                ).value.hit.power,
            )
        }
    }

    @Test
    fun effectivePowerOverrideReplacesDynamicPowerButPreservesTypeAndModifiers() {
        for (move in listOf(
            Move(MoveId("WeatherBall"), PokemonType.NORMAL, 50, Category.SPECIAL),
            Move(MoveId("LowKick"), PokemonType.FIGHTING, 1, Category.PHYSICAL),
        )) {
            val request =
                DamageRequest(
                    pokemon,
                    pokemon,
                    move,
                    BattleField(weather = Weather.RAIN),
                    effectivePowerOverride = 70,
                )
            val preview = assertIs<Calculation.Success<MovePreview>>(previewMove(request)).value
            assertEquals(70L, preview.power)
            val result =
                assertIs<Calculation.Success<dev.pokemondamage.model.DamageResult>>(
                    calculateDamage(request),
                ).value
            assertEquals(70, result.hit.power)
            val expectedType =
                if (move.id ==
                    MoveId("WeatherBall")
                ) {
                    PokemonType.WATER
                } else {
                    PokemonType.FIGHTING
                }
            assertEquals(TeraType.valueOf(expectedType.name), preview.type)
            val equivalent =
                request.copy(
                    move = Move(MoveId("Tackle"), expectedType, 70, move.category),
                    effectivePowerOverride = null,
                )
            assertEquals(
                assertIs<Calculation.Success<dev.pokemondamage.model.DamageResult>>(
                    calculateDamage(equivalent),
                ).value.hit.rolls,
                result.hit.rolls,
            )
            val technician =
                request.copy(
                    attacker = pokemon.copy(ability = AbilityId("Technician")),
                    effectivePowerOverride = 40,
                )
            assertEquals(
                60,
                assertIs<Calculation.Success<dev.pokemondamage.model.DamageResult>>(
                    calculateDamage(technician),
                ).value.hit.power,
            )
            for (power in listOf(0, 1000)) {
                assertEquals(
                    power.toLong(),
                    assertIs<Calculation.Success<MovePreview>>(
                        previewMove(request.copy(effectivePowerOverride = power)),
                    ).value.power,
                )
            }
            for (power in listOf(-1, 1001)) {
                kotlin.test.assertFailsWith<dev.pokemondamage.model.InputValidationException> {
                    request.copy(effectivePowerOverride = power)
                }
            }
        }
    }

    @Test
    fun unsupportedMovesReturnTheSameFailureContractAsDamage() {
        val request =
            DamageRequest(
                pokemon,
                pokemon,
                Move(MoveId("Counter"), PokemonType.FIGHTING, 0, Category.PHYSICAL),
            )
        val failure = assertIs<Calculation.Failure>(previewMove(request))
        assertEquals(FailureKind.UNSUPPORTED, failure.kind)
        assertEquals("move.Counter", failure.path)
        assertEquals(calculateDamage(request), failure)
    }
}
