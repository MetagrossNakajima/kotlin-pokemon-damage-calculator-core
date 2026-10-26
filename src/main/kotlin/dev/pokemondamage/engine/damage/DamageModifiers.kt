package dev.pokemondamage.engine.damage

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.math.TracedValue
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.rules.ItemRules

/** Final modifiers are chained in battle order and applied separately to each random roll. */
internal object DamageModifiers {
    fun calculate(
        context: DamageContext,
        critical: Boolean,
        effectiveness: Double,
    ): TracedValue {
        val ability = context.attackerAbility?.value.orEmpty()
        val defenderAbility = context.defenderAbility?.value.orEmpty()
        val item = context.attackerItem?.value.orEmpty()
        val firstHit = context.request.hitIndex == 0L
        val type = context.move.type
        val screens = context.defender.sideConditions
        val screened = if (context.physical) screens.reflect else screens.lightScreen
        return ModifierChain("damage", ModifierStage.DAMAGE_MODIFIER)
            .apply {
                add(
                    "Screen",
                    context.field.format.screenModifier,
                    !critical &&
                        ability != "Infiltrator" &&
                        context.move.original.id.value !in screenBreakers &&
                        screened,
                )
                add("Neuroforce", 5120, ability == "Neuroforce" && effectiveness > 1)
                add("Sniper", 6144, ability == "Sniper" && critical)
                add("TintedLens", 8192, ability == "TintedLens" && effectiveness < 1)
                add(defenderAbility, 2048, firstHit && defenderAbility in fullHpAbilities)
                add("FluffyContact", 2048, defenderAbility == "Fluffy" && context.contact)
                add("WaveShield", 2048, defenderAbility == "WaveShield" && context.contact)
                add(
                    "PunkRock",
                    2048,
                    defenderAbility == "PunkRock" && MoveFlag.SOUND in context.move.flags,
                )
                add("IceScales", 2048, defenderAbility == "IceScales" && !context.physical)
                add("FriendGuard", 3072, FieldEffect.FRIEND_GUARD in context.field.effects)
                add(
                    defenderAbility,
                    3072,
                    defenderAbility in superEffectiveReducers && effectiveness > 1,
                )
                add("FluffyFire", 8192, defenderAbility == "Fluffy" && type == TeraType.FIRE)
                add("ExpertBelt", 4915, item == "ExpertBelt" && effectiveness > 1)
                add("LifeOrb", 5324, item == "LifeOrb")
                add(
                    context.defenderItem?.value.orEmpty(),
                    if (defenderAbility == "Ripen") 1024 else 2048,
                    firstHit &&
                        ItemRules.resistType(context.defenderItem) == type &&
                        (effectiveness > 1 || type == TeraType.NORMAL) &&
                        !context.unnerve,
                )
            }.finish()
    }

    private val screenBreakers = setOf("BrickBreak", "RagingBull", "PsychicFangs")
    private val fullHpAbilities = setOf("Multiscale", "ShadowShield")
    private val superEffectiveReducers = setOf("SolidRock", "Filter", "PrismArmor")
}
