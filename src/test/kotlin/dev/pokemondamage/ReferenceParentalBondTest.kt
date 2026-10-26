package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*

class ReferenceParentalBondTest {
    @Test
    fun `AbilityId ParentalBond matches native parent child and ability-free control rolls`() {
        val rows =
            javaClass
                .getResourceAsStream("/reference/parental-bond.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
                .map { it.split('\t') }
        assertEquals(64, rows.size)
        val pokemon =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(200, 100, 100, 100, 100, 100),
                ability = AbilityId("Illuminate"),
            )
        fun rolls(s: String) = s.removePrefix("[").removeSuffix("]").split(',').map(String::toInt)
        for (c in rows) {
            val a =
                pokemon.copy(
                    ability = AbilityId("ParentalBond"),
                    item = c[4].takeUnless { it == "-" }?.let(::ItemId),
                    status = if (c[3].toBooleanStrict()) Status.BURN else null,
                )
            val request =
                DamageRequest(
                    a,
                    pokemon,
                    Move(
                        MoveId("Tackle"),
                        PokemonType.NORMAL,
                        c[0].toInt(),
                        Category.valueOf(c[1]),
                    ),
                    critical = c[2].toBooleanStrict(),
                    hitIndex = c[5].toLong(),
                )
            val actual =
                assertIs<Calculation.Success<DamageResult>>(calculateDamage(request))
                    .value
                    .hit
                    .rolls
            val control =
                assertIs<Calculation.Success<DamageResult>>(
                        calculateDamage(
                            request.copy(attacker = a.copy(ability = AbilityId("Illuminate"))),
                        ),
                    )
                    .value
                    .hit
                    .rolls
            val label = c.take(6).joinToString("/")
            assertEquals(rolls(c[6]), actual, "$label parental hit")
            assertEquals(rolls(c[7]), control, "$label control")
            if (c[5] == "0") assertEquals(control, actual, "parent retains ordinary damage")
            else {
                assertTrue(actual.zip(control).all { (child, parent) -> child <= parent }, label)
                if (c[0] == "80")
                    assertNotEquals(control, actual, "child damage reduction must activate")
            }
        }
    }
}
