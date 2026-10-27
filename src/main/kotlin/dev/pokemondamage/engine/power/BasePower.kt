package dev.pokemondamage.engine.power

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.rules.BattleEffects

/** 補正を適用する前の、技固有の威力計算。 */
internal object BasePower {
    // 大きな命中位置でも移植元と同じ計算になるよう64ビット整数を使う
    fun calculate(context: DamageContext): Long {
        val attacker = context.attacker
        val defender = context.defender
        val power = context.move.power.toLong()
        val attackerItem = context.attackerItem
        return when (context.move.original.id.value) {
            // トリプルアクセル･トリプルキック
            "TripleAxel",
            "TripleKick",
            -> {
                power * (context.request.hitIndex + 1)
            }

            // けたぐり･くさむすび
            "LowKick",
            "GrassKnot",
            -> {
                val weight =
                    BattleEffects.weightHectograms(
                        defender,
                        context.defenderAbility,
                        context.defenderItem,
                    )
                20L + 20 * weightThresholds.count { weight >= it }
            }

            // ヘビーボンバー･ヒートスタンプ
            "HeavySlam",
            "HeatCrash",
            -> {
                val attackerWeight =
                    BattleEffects.weightHectograms(
                        attacker,
                        context.attackerAbility,
                        context.attackerItem,
                    )
                val defenderWeight =
                    BattleEffects.weightHectograms(
                        defender,
                        context.defenderAbility,
                        context.defenderItem,
                    )
                40L + 20 * weightRatios.count { attackerWeight >= defenderWeight * it }
            }

            // アクロバット
            "Acrobatics" -> {
                if (
                    attackerItem == null ||
                    (
                        attackerItem ==
                            ItemId(
                                "NormalGem",
                            ) && context.move.type == TeraType.NORMAL
                    )
                ) {
                    power * 2
                } else {
                    power
                }
            }

            // たたりめ
            "Hex" -> {
                if (defender.status != null || context.defenderAbility == AbilityId("Comatose")) {
                    power * 2
                } else {
                    power
                }
            }

            // エラがみ･でんげきくちばし
            "FishiousRend",
            "BoltBeak",
            -> {
                if (attacker.flags[PokemonFlag.MOVES_FIRST] == true) power * 2 else power
            }

            // ダメおし
            "Assurance" -> {
                if (defender.flags[PokemonFlag.DAMAGED_THIS_TURN] == true) power * 2 else power
            }

            // おはかまいり
            "LastRespects" -> {
                attacker.faintedAllies.lastRespectsPower
            }

            // ふんどのこぶし
            "RageFist" -> {
                attacker.timesHit.rageFistPower
            }

            // ふんか･しおふき･ドラゴンエナジー
            "Eruption",
            "WaterSpout",
            "DragonEnergy",
            -> {
                maxOf(1, 150L * attacker.hp / attacker.stats.hp)
            }

            // じたばた･きしかいせい
            "Flail",
            "Reversal",
            -> {
                val ratio = 48 * attacker.hp / attacker.stats.hp
                when {
                    ratio <= 1 -> 200
                    ratio <= 4 -> 150
                    ratio <= 9 -> 100
                    ratio <= 16 -> 80
                    ratio <= 32 -> 40
                    else -> 20
                }
            }

            // にぎりつぶす･しぼりとる･ハードプレス
            "CrushGrip",
            "WringOut",
            "HardPress",
            -> {
                val maximum = if (context.move.original.id == MoveId("HardPress")) 100L else 120L
                val hpFraction = 100L * (defender.hp * 4096L / defender.stats.hp)
                maxOf(1L, ((maximum * hpFraction + 2047) / 4096) / 100)
            }

            // アシストパワー･つけあがる
            "StoredPower",
            "PowerTrip",
            -> {
                with(attacker.stages) {
                    val positiveStages =
                        listOf(
                            attack,
                            defense,
                            specialAttack,
                            specialDefense,
                            speed,
                            accuracy,
                            evasion,
                        ).sumOf {
                            it.positive
                        }
                    20L * (1 + positiveStages)
                }
            }

            else -> {
                power
            }
        }
    }

    private val weightThresholds = listOf(100, 250, 500, 1000, 2000)
    private val weightRatios = listOf(2, 3, 4, 5)
}
