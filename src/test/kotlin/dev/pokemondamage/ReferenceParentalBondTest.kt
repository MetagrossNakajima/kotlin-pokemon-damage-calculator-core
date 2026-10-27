package dev.pokemondamage

import dev.pokemondamage.fixtures.parentalBondCases
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
            parentalBondCases()
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

        for (c in rows) {
            val a =
                pokemon.copy(
                    ability = AbilityId("ParentalBond"),
                    item = c.item,
                    status = if (c.burn) Status.BURN else null,
                )
            val request =
                DamageRequest(
                    a,
                    pokemon,
                    Move(
                        MoveId("Tackle"),
                        PokemonType.NORMAL,
                        c.power,
                        c.category,
                    ),
                    critical = c.critical,
                    hitIndex = c.hit,
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
            val label = c.toString()
            assertEquals(c.damage, actual, "$label parental hit")
            assertEquals(c.control, control, "$label control")
            if (c.hit == 0L) {
                assertEquals(control, actual, "parent retains ordinary damage")
            } else {
                assertTrue(actual.zip(control).all { (child, parent) -> child <= parent }, label)
                if (c.power == 80) {
                    assertNotEquals(control, actual, "child damage reduction must activate")
                }
            }
        }
    }
}
