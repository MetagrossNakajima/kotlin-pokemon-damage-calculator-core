package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class DamageCalculatorTest {
    private val base =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    private fun request(
        a: PokemonState = base,
        d: PokemonState = base,
        name: String = "Tackle",
        type: PokemonType = PokemonType.NORMAL,
        category: Category = Category.PHYSICAL,
        critical: Boolean = false,
        hit: Int = 0,
        power: Int = 60,
    ) =
        DamageRequest(
            a,
            d,
            Move(MoveId(name), type, power, category),
            critical = critical,
            hitIndex = hit.toLong(),
        )

    private fun result(request: DamageRequest) =
        assertIs<Calculation.Success<DamageResult>>(calculateDamage(request)).value

    @Test
    fun `public calculator returns exact rolls distribution and ordered trace`() {
        val r = result(request())
        assertEquals(
            listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
            r.hit.rolls,
        )
        assertEquals(34, r.min)
        assertEquals(42, r.max)
        assertEquals(17.0, r.minPercent)
        assertEquals(21.0, r.maxPercent)
        assertEquals(DamageKind.NORMAL, r.hit.kind)
        assertEquals(16, r.hit.trace.count { it.id == "Random" })
        assertEquals("Tackle", r.hit.trace.first().id)
        assertEquals("FinalModifiers", r.hit.trace.last().id)
    }

    @Test
    fun `burn applies to physical moves except Guts and Facade`() {
        val burned = base.copy(status = Status.BURN)
        assertEquals(21, result(request(burned)).max)
        assertEquals(42, result(request(burned, category = Category.SPECIAL)).max)
        assertEquals(61, result(request(burned.copy(ability = AbilityId("Guts")))).max)
        assertEquals(81, result(request(burned, name = "Facade")).max)
    }

    @Test
    fun `critical sources respect armor and effective ability suppression`() {
        assertFalse(result(request()).hit.critical)
        assertTrue(result(request(critical = true)).hit.critical)
        for (name in
            listOf("FrostBreath", "StormThrow", "WickedBlow", "SurgingStrikes")) assertTrue(
            result(request(name = name)).hit.critical,
        )
        for (status in listOf(null) + Status.entries) {
            val d =
                base.copy(status = status, toxicCounter = if (status == Status.TOXIC) 1 else null)
            assertEquals(
                status in setOf(Status.POISON, Status.TOXIC),
                result(request(base.copy(ability = AbilityId("Merciless")), d)).hit.critical,
            )
        }
        for (ability in listOf("BattleArmor", "ShellArmor")) {
            val d = base.copy(ability = AbilityId(ability))
            assertFalse(result(request(d = d, critical = true)).hit.critical)
            assertTrue(
                result(request(base.copy(ability = AbilityId("MoldBreaker")), d, critical = true))
                    .hit
                    .critical,
            )
        }
    }

    @TestFactory
    fun `unsupported moves return explicit failures`() =
        listOf("Counter", "Bide", "Comeuppance", "MirrorCoat", "MetalBurst", "Psywave").map { name
            ->
            dynamicTest(name) {
                assertEquals(
                    Calculation.Failure(FailureKind.UNSUPPORTED, "move.$name"),
                    calculateDamage(request(name = name)),
                )
            }
        }

    @TestFactory
    fun `fixed moves use current HP and ignore power stats critical and ordinary modifiers`() =
        listOf(
                "SuperFang" to 50,
                "Ruination" to 50,
                "NaturesMadness" to 50,
                "GuardianofAlola" to 75,
                "FinalGambit" to 40,
                "Endeavor" to 61,
                "SonicBoom" to 20,
                "DragonRage" to 40,
                "SeismicToss" to 50,
                "NightShade" to 50,
                "Fissure" to 101,
                "SheerCold" to 101,
                "HornDrill" to 101,
                "Guillotine" to 101,
            )
            .map { (name, damage) ->
                dynamicTest(name) {
                    for (category in Category.entries) {
                        val r =
                            result(
                                request(
                                    base.copy(currentHp = 40, item = ItemId("LifeOrb")),
                                    base.copy(currentHp = 101),
                                    name = name,
                                    category = category,
                                    critical = true,
                                    power = 0,
                                ),
                            )
                        assertEquals(listOf(damage), r.hit.rolls)
                        assertEquals(DamageKind.FIXED, r.hit.kind)
                        assertFalse(r.hit.critical)
                        assertTrue(r.hit.trace.isEmpty())
                    }
                }
            }

    @Test
    fun `NaturesMadness halves current HP rounding down with minimum one`() {
        for ((hp, expected) in listOf(1 to 1, 2 to 1, 3 to 1, 7 to 3, 101 to 50, 200 to 100)) {
            val r =
                result(
                    request(
                        d = base.copy(currentHp = hp),
                        name = "NaturesMadness",
                        type = PokemonType.FAIRY,
                        category = Category.SPECIAL,
                        power = 0,
                    ),
                )
            assertEquals(listOf(expected), r.hit.rolls, "current HP=$hp")
            assertEquals(DamageKind.FIXED, r.hit.kind)
        }
    }

    @Test
    fun `fixed HP rounding minima and Endeavor lower bound are explicit`() {
        for (hp in 1..8) {
            val d = base.copy(currentHp = hp)
            assertEquals(
                maxOf(1, hp / 2),
                result(request(d = d, name = "SuperFang", power = 0)).max,
            )
            assertEquals(
                hp * 3 / 4,
                result(request(d = d, name = "GuardianofAlola", power = 0)).max,
            )
            assertEquals(0, result(request(d = d, name = "Endeavor", power = 0)).max)
        }
    }

    @Test
    fun `fixed damage respects type immunity Sheer Cold ice immunity and Sturdy OHKO immunity`() {
        val ghost = base.copy(profile = base.profile.copy(types = PokemonTypes(PokemonType.GHOST)))
        assertEquals(0, result(request(d = ghost, name = "SeismicToss", power = 0)).max)
        assertEquals(
            50,
            result(
                    request(
                        base.copy(ability = AbilityId("Scrappy")),
                        ghost,
                        name = "SeismicToss",
                        power = 0,
                    ),
                )
                .max,
        )
        val ice = base.copy(profile = base.profile.copy(types = PokemonTypes(PokemonType.ICE)))
        assertEquals(0, result(request(d = ice, name = "SheerCold", power = 0)).max)
        for (name in listOf("Fissure", "SheerCold", "HornDrill", "Guillotine")) {
            val d = base.copy(ability = AbilityId("Sturdy"))
            assertEquals(0, result(request(d = d, name = name, power = 0)).max)
            assertEquals(
                200,
                result(
                        request(
                            base.copy(ability = AbilityId("MoldBreaker")),
                            d,
                            name = name,
                            power = 0,
                        ),
                    )
                    .max,
            )
        }
        assertEquals(
            50,
            result(
                    request(
                        d = base.copy(ability = AbilityId("Sturdy")),
                        name = "SeismicToss",
                        power = 0,
                    ),
                )
                .max,
        )
    }
}
