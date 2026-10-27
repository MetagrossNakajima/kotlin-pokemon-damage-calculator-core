package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.SingleHit
import dev.pokemondamage.engine.damage.FixedDamage
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.FailureKind
import dev.pokemondamage.rules.MoveRules

/** 指定されたバトル条件と命中位置を使い、レベル50で1発分を計算する。 */
fun calculateDamage(request: DamageRequest): Calculation<DamageResult> {
    if (MoveRules.isUnsupported(request.move.id)) {
        return Calculation.Failure(FailureKind.UNSUPPORTED, "move.${request.move.id.value}")
    }
    val context = DamageContext(request)
    val fixedKind = MoveRules.fixedDamageKind(request.move.id)
    val hit =
        if (fixedKind != null) {
            FixedDamage.calculate(context, fixedKind)
        } else {
            SingleHit.calculate(context)
        }
    return Calculation.Success(DamageResult(hit, request.defender.stats.hp))
}
