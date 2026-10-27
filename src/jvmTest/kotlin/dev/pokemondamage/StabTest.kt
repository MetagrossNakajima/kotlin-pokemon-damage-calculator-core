package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.damage.Stab
import dev.pokemondamage.fixtures.stabCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
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
import dev.pokemondamage.model.TeraType
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class StabTest {
    private val base =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun stab(
        a: PokemonState,
        type: PokemonType = PokemonType.NORMAL,
    ) = Stab.calculate(
        DamageContext(
            DamageRequest(a, base, Move(MoveId("Custom"), type, 60, Category.PHYSICAL)),
        ),
    )

    @TestFactory
    fun `STAB matches reference across types tera abilities and stellar availability`() =
        stabCases().also { assertEquals(720, it.size) }.map { case ->
            val name =
                "${case.species.value}/${case.originalTypes} move=${case.moveType} " +
                    "tera=${case.teraType} ability=${case.ability.value} " +
                    "stellarAvailable=${case.stellarAvailable}"
            dynamicTest(name) {
                val attacker =
                    base.copy(
                        profile = base.profile.copy(id = case.species, types = case.originalTypes),
                        teraType = case.teraType,
                        ability = case.ability,
                        flags =
                            PokemonFlags(
                                mapOf(PokemonFlag.STELLAR_BOOST_AVAILABLE to case.stellarAvailable),
                            ),
                    )
                // テラパゴス（ステラ）のテラクラスターのみ、準備後のステラタイプを検証する。
                val move =
                    if (case.moveType == TeraType.STELLAR) {
                        Move(MoveId("TeraStarstorm"), PokemonType.NORMAL, 120, Category.SPECIAL)
                    } else {
                        Move(
                            MoveId("Custom"),
                            checkNotNull(case.moveType.pokemonType),
                            60,
                            Category.PHYSICAL,
                        )
                    }
                assertEquals(
                    case.expectedModifier,
                    Stab.calculate(DamageContext(DamageRequest(attacker, base, move))),
                )
            }
        }

    @Test
    fun `stellar default availability and Tera Blast use the prepared move type`() {
        val a = base.copy(teraType = TeraType.STELLAR)
        assertEquals(8192, stab(a))
        assertEquals(4915, stab(a, PokemonType.WATER))
        val context =
            DamageContext(
                DamageRequest(
                    a,
                    base,
                    Move(MoveId("TeraBlast"), PokemonType.NORMAL, 80, Category.SPECIAL),
                ),
            )
        assertEquals(4915, Stab.calculate(context))
    }

    @Test
    fun `Adaptability and type changing abilities respect suppression`() {
        assertEquals(8192, stab(base.copy(ability = AbilityId("Adaptability"))))
        for (ability in listOf("Adaptability", "Protean", "Libero")) {
            val a =
                base.copy(
                    ability = AbilityId(ability),
                    flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true)),
                )
            assertEquals(6144, stab(a))
            assertEquals(4096, stab(a, PokemonType.WATER))
        }
    }
}
