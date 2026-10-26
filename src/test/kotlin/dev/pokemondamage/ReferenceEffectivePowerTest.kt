package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ReferenceEffectivePowerTest {
    @TestFactory
    fun `caller counters and damage flag match native resolved power inputs`() =
        javaClass
            .getResourceAsStream("/reference/effective-power.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
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
                    val outputs = rows.map { c ->
                        val count = c[1].toInt()
                        val modified = c[6].toBooleanStrict()
                        val a =
                            pokemon.copy(
                                ability = AbilityId(if (modified) "Technician" else "Illuminate"),
                                item = if (modified) ItemId("LifeOrb") else null,
                                faintedAllies = if (name == "LastRespects") count else 0,
                                timesHit = if (name == "RageFist") count else 0,
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
                                PokemonType.valueOf(c[4]),
                                c[2].toInt(),
                                Category.valueOf(c[5]),
                            )
                        val result =
                            assertIs<Calculation.Success<DamageResult>>(
                                    calculateDamage(DamageRequest(a, d, move)),
                                )
                                .value
                                .hit
                        assertEquals(
                            c[7].toInt(),
                            result.power,
                            "$name count=$count modified=$modified power",
                        )
                        val expected =
                            c[8].removePrefix("[").removeSuffix("]").split(',').map(String::toInt)
                        assertEquals(
                            expected,
                            result.rolls,
                            "$name count=$count modified=$modified damage",
                        )
                        if (!modified)
                            assertEquals(
                                c[3].toInt(),
                                result.power,
                                "independently specified effective base power",
                            )
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
                                .filter { rows[it][1].toInt() >= 6 && rows[it][6] == "false" }
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
