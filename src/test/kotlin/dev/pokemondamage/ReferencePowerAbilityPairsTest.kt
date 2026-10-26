package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ReferencePowerAbilityPairsTest {
    @TestFactory
    fun `each power ability has native full damage and a changing control`() =
        javaClass
            .getResourceAsStream("/reference/power.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .filter { it[0] != "Illuminate" }
            .groupBy { it[0] }
            .also { assertEquals(14, it.size) }
            .map { (ability, rows) ->
                dynamicTest("AbilityId/$ability") {
                    var activated = 0
                    for (c in rows) {
                        fun stats(text: String) =
                            text.split(',').map(String::toInt).let {
                                Stats(it[0], it[1], it[2], it[3], it[4], it[5])
                            }
                        val profile =
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.PSYCHIC),
                                PokemonWeight(100),
                            )
                        val a =
                            PokemonState(
                                profile,
                                stats(c[9]),
                                ability = AbilityId(ability),
                                item = c[1].takeIf { it.isNotEmpty() }?.let(::ItemId),
                                status =
                                    if (ability == "ToxicBoost") Status.POISON else Status.BURN,
                            )
                        val d = PokemonState(profile, stats(c[10]))
                        val flags =
                            c[5].split(',').filter { it.isNotEmpty() }.map(MoveFlag::valueOf)
                        val effects =
                            c[6].split(',').filter { it.isNotEmpty() }.map(FieldEffect::valueOf)
                        val request =
                            DamageRequest(
                                a,
                                d,
                                Move(
                                    MoveId("Tackle"),
                                    PokemonType.valueOf(c[3]),
                                    c[4].toInt(),
                                    Category.valueOf(c[2]),
                                    flags = EnumFlags(*flags.toTypedArray()),
                                ),
                                BattleField(
                                    weather =
                                        if (ability == "SandForce") Weather.SANDSTORM else null,
                                    effects = EnumFlags(*effects.toTypedArray()),
                                ),
                            )
                        fun damage(input: DamageRequest) =
                            assertIs<Calculation.Success<DamageResult>>(calculateDamage(input))
                                .value
                                .hit
                                .rolls
                        fun expected(index: Int): List<Int> {
                            val values =
                                c[index]
                                    .removePrefix("[")
                                    .removeSuffix("]")
                                    .split(',')
                                    .map(String::toInt)
                            return if (values.size == 1) List(16) { values.single() } else values
                        }
                        val actual = damage(request)
                        val control =
                            damage(
                                request.copy(attacker = a.copy(ability = AbilityId("Illuminate"))),
                            )
                        assertEquals(expected(11), actual, c.take(7).toString())
                        assertEquals(expected(12), control, "control ${c.take(7)}")
                        if (actual != control) activated++
                    }
                    assertTrue(
                        activated > 0,
                        "$ability must change final damage in at least one activation case",
                    )
                }
            }
}
