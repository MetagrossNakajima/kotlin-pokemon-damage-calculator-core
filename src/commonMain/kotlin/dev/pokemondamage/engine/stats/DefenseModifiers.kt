package dev.pokemondamage.engine.stats

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.Stat

internal object DefenseModifiers {
    fun calculate(context: DamageContext): ModifierChain {
        val ability = context.defenderAbility?.value.orEmpty()
        val activeDefender = context.activeDefenderAbility?.value.orEmpty()
        val attackerAbility = context.attackerAbility?.value.orEmpty()
        val item = context.defenderItem?.value.orEmpty()
        val species = context.defender.profile.id.value
        val physical = context.physicalDefense
        val effects = context.field.effects
        return ModifierChain("defense", ModifierStage.DEFENSE_MODIFIER).apply {
            // わざわいのたま
            add(
                "BeadsofRuin",
                3072,
                !physical &&
                    activeDefender != "BeadsofRuin" &&
                    (attackerAbility == "BeadsofRuin" || FieldEffect.BEADS_OF_RUIN in effects),
            )
            // わざわいのつるぎ
            add(
                "SwordofRuin",
                3072,
                physical &&
                    activeDefender != "SwordofRuin" &&
                    (attackerAbility == "SwordofRuin" || FieldEffect.SWORD_OF_RUIN in effects),
            )
            // こだいかっせい･クォークチャージ
            add(
                ability,
                5324,
                ParadoxBoost.applies(
                    context.defender,
                    context.defenderAbility,
                    if (physical) Stat.DEFENSE else Stat.SPECIAL_DEFENSE,
                ),
            )
            // フラワーギフト
            add(
                "FlowerGift",
                6144,
                !physical &&
                    (ability == "FlowerGift" || FieldEffect.DEFENDER_FLOWER_GIFT in effects),
            )
            // ふしぎなうろこ
            add("MarvelScale", 6144, ability == "MarvelScale" && physical)
            // くさのけがわ
            add("GrassPelt", 6144, ability == "GrassPelt" && physical)
            // ファーコート
            add("FurCoat", 8192, ability == "FurCoat" && physical)
            // しんかのきせき
            add(
                "Eviolite",
                6144,
                item == "Eviolite" && context.defender.flags[PokemonFlag.CAN_EVOLVE] == true,
            )
            // とつげきチョッキ
            add("AssaultVest", 6144, item == "AssaultVest" && !physical)
            // しんかいのウロコ
            add("DeepSeaScale", 8192, item == "DeepSeaScale" && species == "Clamperl" && !physical)
            // メタルパウダー
            add(
                "MetalPowder",
                8192,
                item == "MetalPowder" &&
                    species == "Ditto" &&
                    physical &&
                    context.defender.flags[PokemonFlag.TRANSFORMED] != true,
            )
        }
    }
}
