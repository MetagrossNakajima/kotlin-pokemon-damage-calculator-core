package dev.pokemondamage

import dev.pokemondamage.engine.combined.CombinedEngine
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.CombinedDamageRequest
import dev.pokemondamage.model.CombinedDamageResult

/** Combines the supplied fixed attack distributions with setup and end-of-turn HP events. */
fun calculateCombinedDamage(request: CombinedDamageRequest): Calculation<CombinedDamageResult> =
    CombinedEngine.calculate(request)
