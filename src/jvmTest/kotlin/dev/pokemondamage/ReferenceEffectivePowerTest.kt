package dev.pokemondamage

import dev.pokemondamage.fixtures.EffectivePowerCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.FaintedAllies
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonFlags
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.TimesHit
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals

class ReferenceEffectivePowerTest {
    @TestFactory
    fun `caller counters and damage flag match native resolved power inputs`() =
        EffectivePowerCases.all
            .groupBy { it.move }
            .also { assertEquals(3, it.size) }
            .map { (name, rows) ->
                dynamicTest("MoveId/$name") {
                    assertEquals(if (name == "Assurance") 4 else 18, rows.size)
                    val pokemon =
                        PokemonState(
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.GRASS),
                                PokemonWeight(100),
                            ),
                            Stats(200, 100, 100, 100, 100, 100),
                            ability = AbilityId("Illuminate"),
                        )
                    val outputs =
                        rows.map { c ->
                            val count = c.count
                            val modified = c.modified
                            val a =
                                pokemon.copy(
                                    ability =
                                        AbilityId(
                                            if (modified) "Technician" else "Illuminate",
                                        ),
                                    item = if (modified) ItemId("LifeOrb") else null,
                                    faintedAllies =
                                        FaintedAllies(
                                            if (name ==
                                                "LastRespects"
                                            ) {
                                                count
                                            } else {
                                                0
                                            },
                                        ),
                                    timesHit = TimesHit(if (name == "RageFist") count else 0),
                                )
                            val d =
                                pokemon.copy(
                                    flags =
                                        PokemonFlags(
                                            mapOf(
                                                PokemonFlag.DAMAGED_THIS_TURN to
                                                    (name == "Assurance" && count == 1),
                                            ),
                                        ),
                                )
                            val move =
                                Move(
                                    MoveId(name),
                                    c.type,
                                    c.inputPower,
                                    c.category,
                                )
                            val result =
                                assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(DamageRequest(a, d, move)),
                                ).value
                                    .hit
                            assertEquals(
                                c.finalPower,
                                result.power,
                                "$name count=$count modified=$modified power",
                            )
                            val expected =
                                c.damage
                            assertEquals(
                                expected,
                                result.rolls,
                                "$name count=$count modified=$modified damage",
                            )
                            if (!modified) {
                                assertEquals(
                                    c.effectiveBasePower,
                                    result.power,
                                    "independently specified effective base power",
                                )
                            }
                            result.rolls
                        }
                    assertNotEquals(
                        outputs.first(),
                        outputs[2],
                        "the count or flag must change damage",
                    )
                    if (name == "RageFist") {
                        val capped =
                            rows.indices
                                .filter { rows[it].count >= 6 && !rows[it].modified }
                                .map { outputs[it] }
                        assertEquals(
                            1,
                            capped.distinct().size,
                            "Rage Fist stops growing after six hits",
                        )
                    }
                }
            }
}
