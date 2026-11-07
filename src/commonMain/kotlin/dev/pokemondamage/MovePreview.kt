package dev.pokemondamage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.power.BasePower
import dev.pokemondamage.model.Calculation
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.FailureKind
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.rules.MoveRules

/** Resolved move before power modifiers (items, abilities and STAB) and damage rounding.
 * This is display information, not an input to calculateDamage: passing it back would
 * apply dynamic move rules twice. Power uses Long just like the calculation engine.
 */
class MovePreview(
    val type: TeraType,
    val power: Long,
    val category: Category,
)

/** Uses the same preparation and base-power rules as damage calculation. */
fun previewMove(request: DamageRequest): Calculation<MovePreview> {
    if (MoveRules.isUnsupported(request.move.id)) {
        return Calculation.Failure(FailureKind.UNSUPPORTED, "move.${request.move.id.value}")
    }
    val context = DamageContext(request)
    return Calculation.Success(
        MovePreview(context.move.type, BasePower.calculate(context), context.move.category),
    )
}
