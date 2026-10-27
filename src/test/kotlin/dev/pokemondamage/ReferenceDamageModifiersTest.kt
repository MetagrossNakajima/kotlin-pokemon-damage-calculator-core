package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.damage.DamageModifiers
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleFormat
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonProfile
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.PokemonWeight
import dev.pokemondamage.model.SideConditions
import dev.pokemondamage.model.Stats
import kotlin.test.Test
import kotlin.test.assertEquals

class ReferenceDamageModifiersTest {
    @Test
    fun `final modifiers match reference with overlapping defense and offense effects`() {
        val rows =
            javaClass
                .getResourceAsStream("/reference/damage-modifiers.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
        assertEquals(5760, rows.size)
        val base =
            PokemonState(
                PokemonProfile(
                    PokemonId("Mew"),
                    PokemonTypes(PokemonType.NORMAL),
                    PokemonWeight(100),
                ),
                Stats(200, 100, 100, 100, 100, 100),
            )
        val differences = mutableListOf<String>()
        for (row in rows) {
            val c = row.split('\t')
            val a =
                base.copy(
                    ability = AbilityId(c[0]),
                    item = c[2].takeIf { it.isNotEmpty() }?.let(::ItemId),
                )
            val screen = c[8].toBooleanStrict()
            val d =
                base.copy(
                    ability = AbilityId(c[1]),
                    item = c[3].takeIf { it.isNotEmpty() }?.let(::ItemId),
                    sideConditions = SideConditions(screen, screen),
                )
            val field =
                BattleField(
                    format = BattleFormat.valueOf(c[7]),
                    effects =
                        if (c[9].toBooleanStrict()) {
                            EnumFlags(FieldEffect.FRIEND_GUARD)
                        } else {
                            EnumFlags()
                        },
                )
            val context =
                DamageContext(
                    DamageRequest(
                        a,
                        d,
                        Move(
                            MoveId("Tackle"),
                            PokemonType.valueOf(c[5]),
                            60,
                            Category.valueOf(c[4]),
                            flags = EnumFlags(MoveFlag.valueOf(c[6])),
                        ),
                        field,
                        hitIndex = c[12].toLong(),
                    ),
                )
            val actual =
                DamageModifiers.calculate(context, c[10].toBooleanStrict(), c[11].toDouble()).value
            if (actual != c[13].toInt()) {
                differences += "$row actual=$actual"
            }
        }
        assertEquals(emptyList(), differences)
    }
}
