package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class ReferenceSuppressionTest {
    @TestFactory
    fun `each ignorable ability matches native suppression and Ability Shield protection`() =
        javaClass
            .getResourceAsStream("/reference/suppression.tsv")!!
            .bufferedReader()
            .readLines()
            .drop(1)
            .map { it.split('\t') }
            .groupBy { it[0] }
            .also { assertEquals(82, it.size) }
            .map { (name, rows) ->
                dynamicTest("AbilityId/$name") {
                    assertEquals(8, rows.size)
                    val pokemon =
                        PokemonState(
                            PokemonProfile(
                                PokemonId("Mew"),
                                PokemonTypes(PokemonType.NORMAL),
                                PokemonWeight(100),
                            ),
                            Stats(200, 100, 100, 100, 100, 100),
                        )
                    for (c in rows) {
                        val shield = c[2].toBooleanStrict()
                        val a = pokemon.copy(ability = AbilityId(c[1]))
                        val d =
                            pokemon.copy(
                                profile = pokemon.profile.copy(id = PokemonId(c[5])),
                                ability = AbilityId(name),
                                item = if (shield) ItemId("AbilityShield") else null,
                            )
                        val request =
                            DamageRequest(
                                a,
                                d,
                                Move(MoveId("Tackle"), PokemonType.NORMAL, 80, Category.SPECIAL),
                                BattleField(
                                    weather = c[6].takeUnless { it == "-" }?.let(Weather::valueOf),
                                ),
                            )
                        val context = DamageContext(request)
                        val expectedAbility = c[3].takeUnless { it == "-" }?.let(::AbilityId)
                        assertEquals(
                            if (shield || c[1] == "Illuminate") AbilityId(name) else null,
                            expectedAbility,
                        )
                        assertEquals(
                            expectedAbility,
                            context.defenderAbility,
                            "$name attacker=${c[1]} shield=$shield",
                        )
                        val result =
                            assertIs<Calculation.Success<DamageResult>>(calculateDamage(request))
                                .value
                                .hit
                                .rolls
                        val native =
                            c[4].removePrefix("[").removeSuffix("]").split(',').map(String::toInt)
                        assertEquals(
                            if (native.size == 1) List(16) { native.single() } else native,
                            result,
                            "$name attacker=${c[1]} shield=$shield damage",
                        )
                        assertEquals(
                            AbilityId(name),
                            d.ability,
                            "calculation must preserve the caller's input",
                        )
                    }
                }
            }
}
