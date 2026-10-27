package dev.pokemondamage

import dev.pokemondamage.fixtures.PowerReferenceCase
import dev.pokemondamage.fixtures.powerReferenceCases
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ReferencePowerAbilityPairsTest {
    @TestFactory
    fun `each power ability has native full damage and a changing control`(): List<DynamicTest> {
        val groups =
            powerReferenceCases()
                .filter { it.ability != AbilityId("Illuminate") }
                .groupBy { it.ability }
        assertEquals(14, groups.size)
        return groups.map { (ability, cases) ->
            dynamicTest("AbilityId/${ability.value}") {
                val activated = cases.count { verifyPair(it) }
                assertTrue(
                    activated > 0,
                    "$ability must change final damage in at least one activation case",
                )
            }
        }
    }

    private fun verifyPair(case: PowerReferenceCase): Boolean {
        val request = case.request()
        val actual = damage(request)
        val controlRequest =
            request.copy(attacker = request.attacker.copy(ability = AbilityId("Illuminate")))
        val control = damage(controlRequest)
        assertEquals(case.expectedDamage, actual, case.name)
        assertEquals(case.expectedControlDamage, control, "control ${case.name}")
        return actual != control
    }

    private fun damage(input: DamageRequest): List<Int> =
        assertIs<Calculation.Success<DamageResult>>(calculateDamage(input)).value.hit.rolls
}
