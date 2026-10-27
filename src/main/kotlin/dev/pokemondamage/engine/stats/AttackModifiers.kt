package dev.pokemondamage.engine.stats

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.TeraType

/**
 * イカサマで相手の能力値を使う場合も、攻撃補正は攻撃側の特性・持ち物を参照する。
 */
internal object AttackModifiers {
    fun calculate(context: DamageContext): ModifierChain {
        val ability = context.attackerAbility?.value.orEmpty()
        val defenderAbility = context.defenderAbility?.value.orEmpty()
        val activeDefender = context.activeDefenderAbility?.value.orEmpty()
        val item = context.attackerItem?.value.orEmpty()
        val species = context.attacker.profile.id.value
        val physical = context.physical
        val type = context.move.type
        val effects = context.field.effects
        return ModifierChain("attack", ModifierStage.ATTACK_MODIFIER).apply {
            // スロースタート
            add("SlowStart", 2048, ability == "SlowStart" && physical)
            // よわき
            add("Defeatist", 2048, ability == "Defeatist")
            // わざわいのうつわ
            add(
                "VesselofRuin",
                3072,
                !physical &&
                    ability != "VesselofRuin" &&
                    (activeDefender == "VesselofRuin" || FieldEffect.VESSEL_OF_RUIN in effects),
            )
            // わざわいのおふだ
            add(
                "TabletsofRuin",
                3072,
                physical &&
                    ability != "TabletsofRuin" &&
                    (activeDefender == "TabletsofRuin" || FieldEffect.TABLETS_OF_RUIN in effects),
            )
            // こだいかっせい･クォークチャージ
            add(
                ability,
                5325,
                ParadoxBoost.applies(
                    context.attacker,
                    context.attackerAbility,
                    if (physical) Stat.ATTACK else Stat.SPECIAL_ATTACK,
                ),
            )
            // トランジスタ
            add("Transistor", 5325, ability == "Transistor" && type == TeraType.ELECTRIC)
            // ハドロンエンジン
            add("HadronEngine", 5461, ability == "HadronEngine" && !physical)
            // ひひいろのこどう
            add("OrichalcumPulse", 5461, ability == "OrichalcumPulse" && physical)
            // フラワーギフト
            add(
                "FlowerGift",
                6144,
                physical &&
                    (ability == "FlowerGift" || FieldEffect.ATTACKER_FLOWER_GIFT in effects),
            )
            // こんじょう
            add("Guts", 6144, ability == "Guts" && physical)
            // しんりょく･もうか･げきりゅう･むしのしらせ
            add(ability, 6144, lowHpTypes[ability] == type)
            // もらいび
            add("FlashFire", 6144, ability == "FlashFire" && type == TeraType.FIRE)
            // サンパワー
            add("SolarPower", 6144, ability == "SolarPower" && !physical)
            // プラス･マイナス
            add(ability, 6144, ability in setOf("Plus", "Minus") && !physical)
            // タイプ強化特性
            add(ability, 6144, boostedTypes[ability] == type)
            // ごりむちゅう
            add("GorillaTactics", 6144, ability == "GorillaTactics" && physical)
            // ちからもち･ヨガパワー
            add(ability, 8192, ability in setOf("HugePower", "PurePower") && physical)
            // すいほう
            add("WaterBubble", 8192, ability == "WaterBubble" && type == TeraType.WATER)
            // はりこみ
            add("Stakeout", 8192, ability == "Stakeout")
            // はがねのせいしん（味方）
            add(
                "AllySteelySpirit",
                6144,
                FieldEffect.STEELY_SPIRIT in effects && type == TeraType.STEEL,
            )
            // あついしぼう
            add(
                "ThickFat",
                2048,
                defenderAbility == "ThickFat" && type in setOf(TeraType.FIRE, TeraType.ICE),
            )
            // たいねつ
            add("Heatproof", 2048, defenderAbility == "Heatproof" && type == TeraType.FIRE)
            // すいほう
            add(
                "DefenderWaterBubble",
                2048,
                defenderAbility == "WaterBubble" && type == TeraType.FIRE,
            )
            // きよめのしお
            add("PurifyingSalt", 2048, defenderAbility == "PurifyingSalt" && type == TeraType.GHOST)
            // こだわりハチマキ･こだわりメガネ
            val choiceItem = if (physical) "ChoiceBand" else "ChoiceSpecs"
            add(item, 6144, item == choiceItem)
            // ふといホネ
            add(
                "ThickClub",
                8192,
                item == "ThickClub" &&
                    species in setOf("Marowak", "Marowak-Alola", "Cubone") &&
                    physical,
            )
            // しんかいのキバ
            add("DeepSeaTooth", 8192, item == "DeepSeaTooth" && species == "Clamperl" && !physical)
            // でんきだま
            add("LightBall", 8192, item == "LightBall" && species == "Pikachu")
        }
    }

    private val lowHpTypes =
        mapOf(
            "Overgrow" to TeraType.GRASS,
            "Blaze" to TeraType.FIRE,
            "Torrent" to TeraType.WATER,
            "Swarm" to TeraType.BUG,
        )
    private val boostedTypes =
        mapOf(
            "RockyPayload" to TeraType.ROCK,
            "Steelworker" to TeraType.STEEL,
            "FireMane" to TeraType.FIRE,
            "DragonsMaw" to TeraType.DRAGON,
        )
}
