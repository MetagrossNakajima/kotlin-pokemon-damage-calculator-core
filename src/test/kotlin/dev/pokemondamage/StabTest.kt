package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.damage.Stab
import dev.pokemondamage.model.*
import kotlin.test.*

class StabTest {
    private val base =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun stab(a: PokemonState, type: PokemonType = PokemonType.NORMAL) =
        Stab.calculate(
            DamageContext(
                DamageRequest(a, base, Move(MoveId("Custom"), type, 60, Category.PHYSICAL)),
            ),
        )

    @Test
    fun `STAB matches reference across types tera abilities and stellar availability`() {
        val rows =
            javaClass
                .getResourceAsStream("/reference/stab.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
        assertEquals(720, rows.size)
        val differences = mutableListOf<String>()
        for (row in rows) {
            val c = row.split('\t')
            val types = c[1].split(',').map(PokemonType::valueOf)
            val a =
                base.copy(
                    profile =
                        base.profile.copy(
                            id = PokemonId(c[0]),
                            types = PokemonTypes(types[0], types.getOrNull(1)),
                        ),
                    teraType = c[3].takeIf { it.isNotEmpty() }?.let(TeraType::valueOf),
                    ability = AbilityId(c[4]),
                    flags =
                        PokemonFlags(
                            mapOf(PokemonFlag.STELLAR_BOOST_AVAILABLE to c[5].toBooleanStrict()),
                        ),
                )
            // Tera Starstorm prepares Stellar on Terapagos-Stellar; ordinary moves preserve caller
            // type.
            val move =
                if (c[2] == "STELLAR")
                    Move(MoveId("TeraStarstorm"), PokemonType.NORMAL, 120, Category.SPECIAL)
                else Move(MoveId("Custom"), PokemonType.valueOf(c[2]), 60, Category.PHYSICAL)
            val actual = Stab.calculate(DamageContext(DamageRequest(a, base, move)))
            if (actual != c[6].toInt()) differences += "$row actual=$actual"
        }
        assertEquals(emptyList(), differences)
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
