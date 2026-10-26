package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.power.FinalPower
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
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
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class FinalPowerTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun power(
        a: PokemonState = pokemon,
        name: String = "Custom",
        type: PokemonType = PokemonType.NORMAL,
        input: Int = 40,
        priority: Int = 0,
        hit: Int = 0,
        field: BattleField = BattleField(),
    ) = FinalPower.calculate(
        DamageContext(
            DamageRequest(
                a,
                pokemon,
                Move(MoveId(name), type, input, Category.PHYSICAL, priority = priority),
                field,
                hitIndex = hit.toLong(),
            ),
        ),
    )

    @Test
    fun `power records base transformation modifier application and tera minimum in order`() {
        val a = pokemon.copy(teraType = TeraType.NORMAL, ability = AbilityId("Technician"))
        val result = power(a, input = 30)
        assertEquals(60, result.value)
        assertEquals(
            listOf(
                ModifierTrace("Custom", ModifierStage.BASE_POWER, 30, 30, 30, 30),
                ModifierTrace("Technician", ModifierStage.POWER_MODIFIER, 6144, 4096, 4096, 6144),
                ModifierTrace("powerModifiers", ModifierStage.POWER, 6144, 4096, 30, 45),
                ModifierTrace("TeraMinimum", ModifierStage.POWER, 60, 45, 45, 60),
            ),
            result.trace,
        )
        val transformed = power(name = "Acrobatics")
        assertEquals(80, transformed.value)
        assertEquals(
            ModifierTrace("Acrobatics", ModifierStage.BASE_POWER, 80, 40, 40, 80),
            transformed.trace.first(),
        )
    }

    @Test
    fun `tera minimum checks modified power and uses half down rounding`() {
        val a = pokemon.copy(teraType = TeraType.NORMAL, ability = AbilityId("Technician"))
        for (
        (input, expected) in
        listOf(39 to 60, 40 to 60, 41 to 61, 60 to 90, 61 to 61)
        ) {
            assertEquals(
                expected,
                power(a, input = input).value,
            )
        }
        assertEquals(58, power(a.copy(teraType = null), input = 39).value)
        assertEquals(39, power(pokemon.copy(teraType = TeraType.WATER), input = 39).value)
        assertEquals(
            60,
            power(
                pokemon.copy(teraType = TeraType.FIRE),
                name = "WeatherBall",
                field = BattleField(weather = Weather.SUNLIGHT),
                input = 20,
            ).value,
        )
        assertEquals(
            60,
            power(
                pokemon.copy(teraType = TeraType.GRASS),
                name = "SolarBeam",
                type = PokemonType.GRASS,
                input = 100,
                field = BattleField(weather = Weather.RAIN),
            ).value,
        )
    }

    @Test
    fun `stellar boost respects availability with Terapagos exception`() {
        val a = pokemon.copy(teraType = TeraType.STELLAR)
        assertEquals(60, power(a).value)
        for (available in listOf(true, false)) {
            val flagged =
                a.copy(
                    flags = PokemonFlags(mapOf(PokemonFlag.STELLAR_BOOST_AVAILABLE to available)),
                )
            assertEquals(if (available) 60 else 40, power(flagged).value)
            assertEquals(
                60,
                power(
                    flagged.copy(
                        profile = flagged.profile.copy(id = PokemonId("Terapagos-Stellar")),
                    ),
                ).value,
            )
        }
    }

    @Test
    fun `positive priority prevents minimum but zero and negative priorities allow it`() {
        val a = pokemon.copy(teraType = TeraType.NORMAL)
        for (priority in -7..5) {
            assertEquals(
                if (priority > 0) 40 else 60,
                power(a, priority = priority).value,
            )
        }
    }

    @TestFactory
    fun `every natural multi hit move retains its low per-hit power`() =
        listOf(
            "DoubleKick",
            "SurgingStrikes",
            "DoubleHit",
            "Bonemerang",
            "DoubleIronBash",
            "DragonDarts",
            "DualChop",
            "DualWingbeat",
            "GearGrind",
            "Twineedle",
            "TwinBeam",
            "TripleDive",
            "BulletSeed",
            "RockBlast",
            "IcicleSpear",
            "PinMissile",
            "TailSlap",
            "ArmThrust",
            "Barrage",
            "BoneRush",
            "CometPunch",
            "DoubleSlap",
            "FuryAttack",
            "FurySwipes",
            "SpikeCannon",
            "WaterShuriken",
            "ScaleShot",
            "TripleAxel",
            "TripleKick",
            "PopulationBomb",
        ).map { name ->
            dynamicTest(name) {
                assertEquals(
                    40,
                    power(pokemon.copy(teraType = TeraType.NORMAL), name = name).value,
                )
                assertEquals(
                    40,
                    power(pokemon.copy(teraType = TeraType.STELLAR), name = name).value,
                )
            }
        }

    @TestFactory
    fun `HP proportional moves never receive the tera minimum`() =
        listOf("Eruption", "WaterSpout", "DragonEnergy").map { name ->
            dynamicTest(name) {
                assertEquals(
                    1,
                    power(pokemon.copy(teraType = TeraType.NORMAL, currentHp = 1), name = name)
                        .value,
                )
                assertEquals(
                    150,
                    power(pokemon.copy(teraType = TeraType.NORMAL), name = name).value,
                )
            }
        }

    @Test
    fun `large hit positions retain wide trace and wrap only after applying modifiers`() {
        val r =
            power(
                pokemon.copy(ability = AbilityId("Analytic")),
                name = "TripleKick",
                input = 1000,
                hit = Int.MAX_VALUE,
            )
        assertEquals(0, r.value)
        assertEquals(2147483648000L, r.trace.first().after)
        assertEquals(2147483648000L, r.trace.last().before)
        assertEquals(2791833600000L, r.trace.last().after)
        val zero = power(name = "SeismicToss", input = 0)
        assertEquals(1, zero.value)
        assertEquals(1L, zero.trace.first().denominator)
        // The fixed-damage engine bypasses this stage; this checks arithmetic only.
    }
}
