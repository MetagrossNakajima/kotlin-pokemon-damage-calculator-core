package dev.pokemondamage

import dev.pokemondamage.fixtures.baseDamageCases
import dev.pokemondamage.fixtures.damageRollCases
import dev.pokemondamage.fixtures.typeMatchupCases
import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.math.DamageRoll
import dev.pokemondamage.rules.TypeChart
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class ReferenceArithmeticTest {
    @TestFactory
    fun `all 324 type matchups agree with Reference generation nine`() =
        typeMatchupCases()
            .also { cases ->
                assertEquals(324, cases.size)
                assertEquals(324, cases.map { it.attack to it.defense }.toSet().size)
            }.map { case ->
                dynamicTest("${case.attack} against ${case.defense}") {
                    assertEquals(case.expected, TypeChart.effectiveness(case.attack, case.defense))
                }
            }

    @TestFactory
    fun `base damage agrees with Reference including overflow`() =
        baseDamageCases().also { assertEquals(150, it.size) }.map { case ->
            dynamicTest("power=${case.power} attack=${case.attack} defense=${case.defense}") {
                assertEquals(
                    case.expected,
                    BattleMath.baseDamage(case.power, case.attack, case.defense),
                )
            }
        }

    @TestFactory
    fun `all final damage rolls agree with Reference`() =
        damageRollCases()
            .also { cases ->
                assertEquals(1400, cases.size)
                assertEquals(22400, cases.sumOf { it.expectedRolls.size })
            }.flatMap { case ->
                assertEquals(16, case.expectedRolls.size)
                case.expectedRolls.mapIndexed { index, expected ->
                    val random = 85 + index
                    val name =
                        "base=${case.baseDamage} random=$random type=${case.effectiveness} " +
                            "burn=${case.burned} stab=${case.stab} modifier=${case.finalModifier}"
                    dynamicTest(name) {
                        assertEquals(
                            expected,
                            DamageRoll.calculate(
                                baseDamage = case.baseDamage,
                                randomPercent = random,
                                effectiveness = case.effectiveness,
                                burned = case.burned,
                                stab = case.stab,
                                finalModifier = case.finalModifier,
                            ),
                        )
                    }
                }
            }

    @Test
    fun `immunity remains zero despite minimum damage rule`() {
        assertEquals(0, DamageRoll.calculate(46, 100, 0.0, false, 6144, 4096))
    }
}
