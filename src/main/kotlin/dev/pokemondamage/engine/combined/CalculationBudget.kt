package dev.pokemondamage.engine.combined

import dev.pokemondamage.model.CalculationLimits

/** 連続計算全体で共有する処理量の上限。失敗しても消費量は戻さない。 */
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
