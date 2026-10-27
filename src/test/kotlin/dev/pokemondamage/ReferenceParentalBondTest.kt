package dev.pokemondamage

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
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
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.zip
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

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

        fun rolls(s: String) =
            s
                .removePrefix("[")
                .removeSuffix("]")
                .split(',')
                .map(String::toInt)
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
                ).value
                    .hit
                    .rolls
            val label = c.take(6).joinToString("/")
            assertEquals(rolls(c[6]), actual, "$label parental hit")
            assertEquals(rolls(c[7]), control, "$label control")
            if (c[5] == "0") {
                assertEquals(control, actual, "parent retains ordinary damage")
            } else {
                assertTrue(actual.zip(control).all { (child, parent) -> child <= parent }, label)
                if (c[0] == "80") {
                    assertNotEquals(control, actual, "child damage reduction must activate")
                }
            }
        }
    }
}
