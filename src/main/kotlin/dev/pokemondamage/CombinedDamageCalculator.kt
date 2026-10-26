package dev.pokemondamage

import dev.pokemondamage.engine.combined.CombinedEngine
import dev.pokemondamage.model.*

/** Combines the supplied fixed attack distributions with setup and end-of-turn HP events. */
fun calculateCombinedDamage(request: CombinedDamageRequest): Calculation<CombinedDamageResult> =
    CombinedEngine.calculate(request)
