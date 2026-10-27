package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.power.FinalPower
import dev.pokemondamage.engine.power.PowerModifiers
import dev.pokemondamage.fixtures.powerReferenceCases
import dev.pokemondamage.fixtures.teraPowerReferenceCases
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.DamageResult
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ReferencePowerTest {
    @TestFactory
    fun `power modifier chains match native Reference under explicit active conditions`() =
        powerReferenceCases().also { assertEquals(2160, it.size) }.map { case ->
            dynamicTest(case.name) {
                val context = DamageContext(case.request())
                assertEquals(
                    case.expectedMultiplier,
                    PowerModifiers.calculate(context, case.move.power.toLong()).finish().value,
                    "power modifier",
                )
                assertEquals(case.expectedPower, FinalPower.calculate(context).value, "final power")
                val damage =
                    assertIs<Calculation.Success<DamageResult>>(
                        calculateDamage(context.request),
                    ).value.hit.rolls
                assertEquals(case.expectedDamage, damage, "complete damage")
            }
        }

    @TestFactory
    fun `tera minimum and its exceptions match native Reference final power`() =
        teraPowerReferenceCases().also { assertEquals(1152, it.size) }.map { case ->
            dynamicTest(case.name) {
                assertEquals(
                    case.expectedPower,
                    FinalPower.calculate(DamageContext(case.request())).value,
                )
            }
        }
}
