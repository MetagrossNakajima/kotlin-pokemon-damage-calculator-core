package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.CalculationLimits

/** Shared by every phase of a combined calculation; failure never resets spent work. */
internal class CalculationBudget(
    private val limits: CalculationLimits,
) {
    private var operations = 0L

    fun spend(
        count: Long,
        states: Int,
    ): Boolean {
        if (count > limits.maxOperations - operations || states > limits.maxStates) {
            return false
        }
        operations += count
        return true
    }
}
