package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.SingleHit
import dev.pokemondamage.engine.damage.FixedDamage
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.DamageResult
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FailureKind
import dev.pokemondamage.model.MoveFlag
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
    // 同値のシェルアームズは特殊・物理を等確率で選ぶ。各分類の補正と接触判定も別計算する。
    val alternativeHit =
        if (context.move.categoryTied) {
            val physicalFlags = context.move.flags.values + MoveFlag.CONTACT
            val physicalMove =
                context.move.copy(
                    category = Category.PHYSICAL,
                    flags = EnumFlags(*physicalFlags.toTypedArray()),
                    categoryTied = false,
                )
            SingleHit.calculate(DamageContext(request, physicalMove))
        } else {
            null
        }
    return Calculation.Success(DamageResult(hit, request.defender.stats.hp, alternativeHit))
}
