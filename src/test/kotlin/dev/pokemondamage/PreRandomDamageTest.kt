package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.damage.ParentalBond
import dev.pokemondamage.engine.damage.PreRandomDamage
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.BattleFormat
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace
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
import dev.pokemondamage.model.Weather
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PreRandomDamageTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun context(
        a: PokemonState = pokemon,
        d: PokemonState = pokemon,
        name: String = "Custom",
        type: PokemonType = PokemonType.NORMAL,
        spread: Boolean = false,
        field: BattleField = BattleField(),
        hit: Int = 0,
    ) = DamageContext(
        DamageRequest(
            a,
            d,
            Move(MoveId(name), type, 60, Category.PHYSICAL, spread = spread),
            field,
            hitIndex = hit.toLong(),
        ),
    )

    private fun damage(
        c: DamageContext = context(),
        critical: Boolean = false,
    ) = PreRandomDamage.calculate(c, 60, 100, 100, critical)

    @Test
    fun `base damage and critical floor retain exact trace`() {
        val r = damage()
        assertEquals(28, r.value)
        assertEquals(
            listOf(ModifierTrace("BaseDamage", ModifierStage.DAMAGE, 1, 1, 28, 28)),
            r.trace,
        )
        val critical = PreRandomDamage.calculate(context(), 61, 100, 100, true)
        assertEquals(42, critical.value)
        assertEquals(
            ModifierTrace("Critical", ModifierStage.DAMAGE, 6144, 4096, 28, 42),
            critical.trace.last(),
        )
        assertEquals(43, PreRandomDamage.calculate(context(), 62, 100, 100, true).value)
    }

    @Test
    fun `spread reduction requires doubles and a spread move`() {
        for (format in BattleFormat.entries) {
            for (spread in listOf(true, false)) {
                assertEquals(
                    if (format == BattleFormat.DOUBLE && spread) 21 else 28,
                    damage(context(spread = spread, field = BattleField(format = format))).value,
                )
            }
        }
    }

    @Test
    fun `Parental Bond excludes natural multihit and spread only in doubles`() {
        val a = pokemon.copy(ability = AbilityId("ParentalBond"))
        assertFalse(ParentalBond.applies(context()))
        assertTrue(ParentalBond.applies(context(a)))
        assertFalse(ParentalBond.applies(context(a, name = "DoubleKick")))
        for (format in BattleFormat.entries) {
            for (spread in listOf(true, false)) {
                val field = BattleField(format = format)
                val applies = format != BattleFormat.DOUBLE || !spread
                assertEquals(
                    applies,
                    ParentalBond.applies(context(a, spread = spread, field = field)),
                )
                for (hit in 0..2) {
                    assertEquals(
                        if (!applies) {
                            21
                        } else if (hit == 1) {
                            7
                        } else {
                            28
                        },
                        damage(context(a, spread = spread, field = field, hit = hit)).value,
                    )
                }
            }
        }
        assertEquals(
            28,
            damage(
                context(
                    a.copy(flags = PokemonFlags(mapOf(PokemonFlag.ABILITY_SUPPRESSED to true))),
                    hit = 1,
                ),
            ).value,
        )
    }

    @Test
    fun `weather applies by effective type and the defenders active umbrella`() {
        for (weather in listOf(null) + Weather.entries) {
            for (type in PokemonType.entries) {
                val field = BattleField(weather = weather)
                val expected =
                    when {
                        (weather == Weather.SUNLIGHT && type == PokemonType.FIRE) ||
                            (weather == Weather.RAIN && type == PokemonType.WATER) -> 42

                        (weather == Weather.SUNLIGHT && type == PokemonType.WATER) ||
                            (weather == Weather.RAIN && type == PokemonType.FIRE) -> 14

                        else -> 28
                    }
                assertEquals(expected, damage(context(type = type, field = field)).value)
                assertEquals(
                    expected,
                    damage(
                        context(
                            pokemon.copy(item = ItemId("UtilityUmbrella")),
                            type = type,
                            field = field,
                        ),
                    ).value,
                )
                assertEquals(
                    28,
                    damage(
                        context(
                            d = pokemon.copy(item = ItemId("UtilityUmbrella")),
                            type = type,
                            field = field,
                        ),
                    ).value,
                )
                assertEquals(
                    expected,
                    damage(
                        context(
                            d =
                                pokemon.copy(
                                    item = ItemId("UtilityUmbrella"),
                                    ability = AbilityId("Klutz"),
                                ),
                            type = type,
                            field = field,
                        ),
                    ).value,
                )
            }
        }
        assertEquals(
            28,
            damage(
                context(
                    d = pokemon.copy(ability = AbilityId("CloudNine")),
                    type = PokemonType.FIRE,
                    field = BattleField(weather = Weather.SUNLIGHT),
                ),
            ).value,
        )
    }

    @Test
    fun `Hydro Steam sunlight precedes defender umbrella and respects attacker umbrella`() {
        val umbrella = pokemon.copy(item = ItemId("UtilityUmbrella"))
        val sun = BattleField(weather = Weather.SUNLIGHT)
        assertEquals(
            42,
            damage(context(name = "HydroSteam", type = PokemonType.WATER, field = sun)).value,
        )
        assertEquals(
            42,
            damage(
                context(
                    d = umbrella,
                    name = "HydroSteam",
                    type = PokemonType.WATER,
                    field = sun,
                ),
            ).value,
        )
        assertEquals(
            14,
            damage(context(umbrella, name = "HydroSteam", type = PokemonType.WATER, field = sun))
                .value,
        )
        assertEquals(
            28,
            damage(
                context(
                    umbrella,
                    umbrella,
                    name = "HydroSteam",
                    type = PokemonType.WATER,
                    field = sun,
                ),
            ).value,
        )
        assertEquals(
            42,
            damage(
                context(
                    name = "HydroSteam",
                    type = PokemonType.WATER,
                    field = BattleField(weather = Weather.RAIN),
                ),
            ).value,
        )
        assertEquals(28, damage(context(name = "HydroSteam", type = PokemonType.WATER)).value)
        assertEquals(
            42,
            damage(
                context(
                    pokemon.copy(ability = AbilityId("MegaSol")),
                    pokemon.copy(ability = AbilityId("CloudNine")),
                    name = "HydroSteam",
                    type = PokemonType.WATER,
                ),
            ).value,
        )
    }

    @Test
    fun `child hit weather and critical round at each stage in order`() {
        val c =
            context(
                pokemon.copy(ability = AbilityId("ParentalBond")),
                type = PokemonType.FIRE,
                hit = 1,
                field = BattleField(weather = Weather.SUNLIGHT),
            )
        val r = damage(c, true)
        assertEquals(15, r.value) // 28 → 7 → 10（端数0.5を切り捨て）→ 15。
        assertEquals(
            listOf("BaseDamage", "ParentalBond", "Weather", "Critical"),
            r.trace.map { it.id },
        )
        assertEquals(listOf(28L, 7L, 10L, 15L), r.trace.map { it.after })
        val spread =
            damage(
                context(
                    type = PokemonType.WATER,
                    spread = true,
                    field = BattleField(format = BattleFormat.DOUBLE, weather = Weather.RAIN),
                ),
                true,
            )
        assertEquals(46, spread.value) // 28 -> 21 -> 31 -> 46.
    }
}
