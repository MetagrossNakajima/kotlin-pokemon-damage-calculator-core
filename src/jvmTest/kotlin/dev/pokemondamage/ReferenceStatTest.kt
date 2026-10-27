package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.stats.AttackStat
import dev.pokemondamage.engine.stats.DefenseStat
import dev.pokemondamage.fixtures.statReferenceCases
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.DamageResult
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs

class ReferenceStatTest {
    @TestFactory
    fun `attack and defense stages agree with Reference under explicit active conditions`() =
        statReferenceCases()
            .also { cases ->
                assertEquals(1122, cases.size)
                assertEquals(cases.size, cases.map { it.name }.toSet().size)
            }.map { case ->
                dynamicTest(case.name) {
                    val context = DamageContext(case.request())
                    assertEquals(
                        case.expectedAttack,
                        AttackStat.calculate(context, case.critical).value,
                    )
                    assertEquals(
                        case.expectedDefense,
                        DefenseStat.calculate(context, case.critical).value,
                    )
                    val full =
                        assertIs<Calculation.Success<DamageResult>>(
                            calculateDamage(context.request),
                        ).value
                    assertEquals(case.expectedDamage, full.hit.rolls)
                }
            }
}
