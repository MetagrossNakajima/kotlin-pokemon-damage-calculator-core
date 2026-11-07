package dev.pokemondamage

import dev.pokemondamage.fixtures.StatControlRole
import dev.pokemondamage.fixtures.StatReferenceCase
import dev.pokemondamage.fixtures.statReferenceCases
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

class ReferenceStatAbilityPairsTest {
    @TestFactory
    fun `each stat ability matches native damage and has an activating control pair`():
        List<DynamicTest> {
        val groups =
            statReferenceCases()
                .filter { it.controlRole != null }
                .groupBy { checkNotNull(it.controlAbility) }
        assertEquals(35, groups.size)
        return groups.map { (ability, cases) ->
            dynamicTest("AbilityId/${ability.value}") {
                val activatingPairs = cases.count { verifyPair(it) }
                assertTrue(
                    activatingPairs > 0,
                    "$ability must change damage in at least one tested activation condition",
                )
            }
        }
    }

    private fun verifyPair(case: StatReferenceCase): Boolean {
        val request = case.request()
        val control =
            if (case.controlRole == StatControlRole.ATTACKER) {
                val attacker =
                    request.attacker.copy(
                        ability = AbilityId("Illuminate"),
                        boostedStat = null,
                    )
                request.copy(attacker = attacker)
            } else {
                val defender =
                    request.defender.copy(
                        ability = AbilityId("Illuminate"),
                        boostedStat = null,
                    )
                request.copy(defender = defender)
            }
        val active = calculate(request)
        val inactive = calculate(control)
        assertEquals(case.expectedDamage, active, "${case.name} active")
        assertEquals(case.expectedControlDamage, inactive, "${case.name} control")
        return active != inactive
    }

    private fun calculate(input: DamageRequest): List<Int> =
        assertIs<Calculation.Success<DamageResult>>(calculateDamage(input)).value.hit.rolls
}
