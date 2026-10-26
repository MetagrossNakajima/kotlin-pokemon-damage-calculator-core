package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.SingleHit
import dev.pokemondamage.engine.damage.FixedDamage
import dev.pokemondamage.model.*
import dev.pokemondamage.rules.MoveRules

/**
 * Calculates one hit at level 50 using the caller's explicit battle conditions and hit position.
 */
fun calculateDamage(request: DamageRequest): Calculation<DamageResult> {
    if (MoveRules.isUnsupported(request.move.id)) {
        return Calculation.Failure(FailureKind.UNSUPPORTED, "move.${request.move.id.value}")
    }
    val context = DamageContext(request)
    val hit =
        if (MoveRules.isFixedDamage(request.move.id)) FixedDamage.calculate(context)
        else SingleHit.calculate(context)
    return Calculation.Success(DamageResult(hit, request.defender.stats.hp))
}
