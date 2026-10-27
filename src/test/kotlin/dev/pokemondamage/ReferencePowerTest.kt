package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.power.FinalPower
import dev.pokemondamage.engine.power.PowerModifiers
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
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
import dev.pokemondamage.model.Status
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ReferencePowerTest {
    @Test
    fun `power modifier chains match native Reference under explicit active conditions`() {
        val rows =
            javaClass
                .getResourceAsStream("/reference/power.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
        assertEquals(2160, rows.size)
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

            fun stats(text: String) =
                text.split(',').map(String::toInt).let {
                    Stats(it[0], it[1], it[2], it[3], it[4], it[5])
                }
            val nativeBase =
                base.copy(profile = base.profile.copy(types = PokemonTypes(PokemonType.PSYCHIC)))
            val attacker =
                nativeBase.copy(
                    stats = stats(c[9]),
                    ability = AbilityId(c[0]),
                    item = c[1].takeIf { it.isNotEmpty() }?.let(::ItemId),
                    status = if (c[0] == "ToxicBoost") Status.POISON else Status.BURN,
                )
            val flags = c[5].split(',').filter { it.isNotEmpty() }.map(MoveFlag::valueOf)
            val effects = c[6].split(',').filter { it.isNotEmpty() }.map(FieldEffect::valueOf)
            val context =
                DamageContext(
                    DamageRequest(
                        attacker,
                        nativeBase.copy(stats = stats(c[10])),
                        Move(
                            MoveId("Tackle"),
                            PokemonType.valueOf(c[3]),
                            c[4].toInt(),
                            Category.valueOf(c[2]),
                            flags = EnumFlags(*flags.toTypedArray()),
                        ),
                        BattleField(
                            weather = if (c[0] == "SandForce") Weather.SANDSTORM else null,
                            effects = EnumFlags(*effects.toTypedArray()),
                        ),
                    ),
                )
            val actual = PowerModifiers.calculate(context, c[4].toLong()).finish().value
            if (actual != c[7].toInt()) {
                differences += "$row actual=$actual"
            }
            val finalPower = FinalPower.calculate(context).value
            if (finalPower != c[8].toInt()) {
                differences += "$row finalPower=$finalPower"
            }
            val damage =
                assertIs<Calculation.Success<DamageResult>>(calculateDamage(context.request))
                    .value
                    .hit
                    .rolls
            val encoded =
                c[11]
                    .removePrefix("[")
                    .removeSuffix("]")
                    .split(',')
                    .map(String::toInt)
            val expected = if (encoded.size == 1) List(16) { encoded.single() } else encoded
            if (damage != expected) {
                differences += "$row actualDamage=$damage"
            }
        }
        assertEquals(emptyList(), differences)
    }

    @Test
    fun `tera minimum and its exceptions match native Reference final power`() {
        val rows =
            javaClass
                .getResourceAsStream("/reference/tera-power.tsv")!!
                .bufferedReader()
                .readLines()
                .drop(1)
        assertEquals(1152, rows.size)
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
                    ability = AbilityId(c[6]),
                    teraType = c[3].takeIf { it.isNotEmpty() }?.let(TeraType::valueOf),
                    currentHp = c[5].toInt(),
                    flags =
                        PokemonFlags(
                            mapOf(PokemonFlag.STELLAR_BOOST_AVAILABLE to c[4].toBooleanStrict()),
                        ),
                )
            val context =
                DamageContext(
                    DamageRequest(
                        a,
                        base,
                        Move(
                            MoveId(c[0]),
                            PokemonType.NORMAL,
                            c[1].toInt(),
                            Category.PHYSICAL,
                            priority = c[2].toInt(),
                        ),
                    ),
                )
            val actual = FinalPower.calculate(context).value
            if (actual != c[7].toInt()) {
                differences += "$row actual=$actual"
            }
        }
        assertEquals(emptyList(), differences)
    }
}
