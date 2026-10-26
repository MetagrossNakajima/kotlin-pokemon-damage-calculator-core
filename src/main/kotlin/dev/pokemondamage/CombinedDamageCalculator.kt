package dev.pokemondamage

import dev.pokemondamage.engine.combined.CombinedEngine
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult

/** 指定された固定の攻撃分布に、事前処理とターン終了時のHP変化を組み合わせる。 */
fun calculateCombinedDamage(request: CombinedDamageRequest): Calculation<CombinedDamageResult> =
    CombinedEngine.calculate(request)
