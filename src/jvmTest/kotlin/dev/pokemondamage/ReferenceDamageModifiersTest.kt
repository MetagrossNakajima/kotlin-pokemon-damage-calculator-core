package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.damage.DamageModifiers
import dev.pokemondamage.fixtures.damageModifierCases
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.SideConditions
import dev.pokemondamage.model.Stats
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals

class ReferenceDamageModifiersTest {
    private val base =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    @TestFactory
    fun `final modifiers match reference with overlapping defense and offense effects`() =
        damageModifierCases().also { assertEquals(5760, it.size) }.mapIndexed { index, case ->
            val name =
                "case-${index + 1} ${case.attackerAbility.value}/${case.defenderAbility.value} " +
                    "${case.category}/${case.type}/${case.format} hit=${case.hitIndex}"
            dynamicTest(name) {
                val attacker = base.copy(ability = case.attackerAbility, item = case.attackerItem)
                val defender =
                    base.copy(
                        ability = case.defenderAbility,
                        item = case.defenderItem,
                        sideConditions = SideConditions(case.screen, case.screen),
                    )
                val field =
                    BattleField(
                        format = case.format,
                        effects =
                            if (case.friendGuard) {
                                EnumFlags(
                                    FieldEffect.FRIEND_GUARD,
                                )
                            } else {
                                EnumFlags()
                            },
                    )
                val context =
                    DamageContext(
                        DamageRequest(
                            attacker,
                            defender,
                            Move(
                                MoveId("Tackle"),
                                case.type,
                                60,
                                case.category,
                                flags = EnumFlags(case.flag),
                            ),
                            field,
                            hitIndex = case.hitIndex,
                        ),
                    )
                assertEquals(
                    case.expectedModifier,
                    DamageModifiers.calculate(context, case.critical, case.effectiveness).value,
                    case.toString(),
                )
            }
        }
}
