package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.fixtures.SuppressionCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
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
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ReferenceSuppressionTest {
    @TestFactory
    fun `each ignorable ability matches native suppression and Ability Shield protection`() =
        SuppressionCases.all
            .groupBy { it.ability }
            .also { assertEquals(82, it.size) }
            .flatMap { (name, rows) ->
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
                rows.mapIndexed { index, c ->
                    dynamicTest(
                        "AbilityId/$name/${index + 1}/${c.attackerAbility}/shield=${c.shield}",
                    ) {
                        val shield = c.shield
                        val a = pokemon.copy(ability = AbilityId(c.attackerAbility))
                        val d =
                            pokemon.copy(
                                profile = pokemon.profile.copy(id = PokemonId(c.species)),
                                ability = AbilityId(name),
                                item = if (shield) ItemId("AbilityShield") else null,
                            )
                        val request =
                            DamageRequest(
                                a,
                                d,
                                Move(MoveId("Tackle"), PokemonType.NORMAL, 80, Category.SPECIAL),
                                BattleField(
                                    weather = c.weather,
                                ),
                            )
                        val context = DamageContext(request)
                        val expectedAbility = c.resolved?.let(::AbilityId)
                        assertEquals(
                            if (shield ||
                                c.attackerAbility == "Illuminate"
                            ) {
                                AbilityId(name)
                            } else {
                                null
                            },
                            expectedAbility,
                        )
                        assertEquals(
                            expectedAbility,
                            context.defenderAbility,
                            "$name attacker=${c.attackerAbility} shield=$shield",
                        )
                        val result =
                            assertIs<Calculation.Success<DamageResult>>(calculateDamage(request))
                                .value
                                .hit
                                .rolls
                        val native =
                            c.damage
                        assertEquals(
                            if (native.size == 1) List(16) { native.single() } else native,
                            result,
                            "$name attacker=${c.attackerAbility} shield=$shield damage",
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
