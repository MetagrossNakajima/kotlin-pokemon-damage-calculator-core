package dev.pokemondamage.engine

import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonState
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.model.Weather
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.ItemRules

/** 技ごとの順序に従い、タイプ・威力・分類・接触判定を確定する。 */
internal object MovePreparation {
    fun prepare(context: DamageContext): EffectiveMove {
        val original = context.request.move
        val initial =
            EffectiveMove(
                original,
                TeraType.valueOf(original.type.name),
                original.power,
                original.category,
            )
        val prepared = specific(context, initial) ?: ability(context, initial)
        // フォトンゲイザー
        return if (original.id == MoveId("PhotonGeyser")) {
            prepared.copy(category = adaptiveCategory(context.attacker))
        } else {
            prepared
        }
    }

    // ランク込みの攻撃が特攻を上回る場合は物理技
    private fun adaptiveCategory(pokemon: PokemonState): Category =
        if (
            BattleMath.rankedStat(pokemon.stats.attack, pokemon.stages.attack) >
            BattleMath.rankedStat(pokemon.stats.specialAttack, pokemon.stages.specialAttack)
        ) {
            Category.PHYSICAL
        } else {
            Category.SPECIAL
        }

    private fun specific(
        context: DamageContext,
        move: EffectiveMove,
    ): EffectiveMove? {
        val attacker = context.attacker
        return when (move.original.id.value) {
            // さばきのつぶて
            "Judgment" -> {
                move.copy(type = ItemRules.plateType(context.attackerItem) ?: move.type)
            }

            // ツタこんぼう
            "IvyCudgel" -> {
                ability(context, move.copy(type = ivyCudgelType(attacker.profile.id, move.type)))
            }

            // シェルアームズ
            "ShellSideArm" -> {
                shellSideArm(context, ability(context, move))
            }

            // テラバースト
            "TeraBlast" -> {
                attacker.teraType?.let {
                    move.copy(
                        type = it,
                        power = if (it == TeraType.STELLAR) 100 else 80,
                        category = adaptiveCategory(attacker),
                    )
                }
            }

            // テラクラスター
            "TeraStarstorm" -> {
                if (attacker.profile.id == PokemonId("Terapagos-Stellar")) {
                    move.copy(
                        type = TeraType.STELLAR,
                        category =
                            if (attacker.teraType != null) {
                                adaptiveCategory(attacker)
                            } else {
                                move.category
                            },
                    )
                } else {
                    null
                }
            }

            // ウェザーボール
            "WeatherBall" -> {
                weatherBall(context, move)
            }

            // だいちのはどう
            "TerrainPulse" -> {
                context.field.terrain
                    ?.takeIf { context.attackerGrounded }
                    ?.let {
                        move.copy(
                            type = it.terrainPulseType,
                            power = move.power * 2,
                        )
                    }
            }

            // レイジングブル
            "RagingBull" -> {
                move.copy(
                    // ノーマルスキン
                    type =
                        if (context.attackerAbility == AbilityId("Normalize")) {
                            TeraType.NORMAL
                        } else {
                            when (attacker.profile.id.value) {
                                "Tauros-Paldea-Combat" -> TeraType.FIGHTING
                                "Tauros-Paldea-Blaze" -> TeraType.FIRE
                                "Tauros-Paldea-Aqua" -> TeraType.WATER
                                else -> move.type
                            }
                        },
                )
            }

            else -> {
                null
            }
        }
    }

    // ツタこんぼう：フォルムに応じたタイプ
    private fun ivyCudgelType(
        id: PokemonId,
        fallback: TeraType,
    ): TeraType =
        when {
            id.value == "Ogerpon" || id.value.startsWith("Ogerpon-Teal") -> TeraType.GRASS
            id.value.startsWith("Ogerpon-Cornerstone") -> TeraType.ROCK
            id.value.startsWith("Ogerpon-Hearthflame") -> TeraType.FIRE
            id.value.startsWith("Ogerpon-Wellspring") -> TeraType.WATER
            else -> fallback
        }

    private fun shellSideArm(
        context: DamageContext,
        move: EffectiveMove,
    ): EffectiveMove {
        val attacker = context.attacker
        val defender = context.defender
        val wonderRoom = FieldEffect.WONDER_ROOM in context.field.effects
        // ワンダールームでは防御と特防の入れ替えに合わせてランクを選ぶ
        val defenseStage =
            if (wonderRoom) defender.stages.specialDefense else defender.stages.defense
        val specialDefenseStage =
            if (wonderRoom) defender.stages.defense else defender.stages.specialDefense
        val attack = BattleMath.rankedStat(attacker.stats.attack, attacker.stages.attack)
        val specialAttack =
            BattleMath.rankedStat(attacker.stats.specialAttack, attacker.stages.specialAttack)
        val defense = BattleMath.rankedStat(defender.stats.defense, defenseStage)
        val specialDefense =
            BattleMath.rankedStat(defender.stats.specialDefense, specialDefenseStage)
        // 交差積で大小を比較し、同値や能力値0でも除算を避ける
        val physical = attack.toLong() * specialDefense > specialAttack.toLong() * defense
        val flags =
            if (physical) {
                move.flags.values + MoveFlag.CONTACT
            } else {
                move.flags.values - MoveFlag.CONTACT
            }
        return move.copy(
            category = if (physical) Category.PHYSICAL else Category.SPECIAL,
            flags = EnumFlags(*flags.toTypedArray()),
        )
    }

    private fun ability(
        context: DamageContext,
        move: EffectiveMove,
    ): EffectiveMove {
        // ノーマルスキン
        if (context.attackerAbility == AbilityId("Normalize")) {
            return move.copy(type = TeraType.NORMAL)
        }
        // スキン系特性
        val skin = AbilityRules.skinType(context.attackerAbility)
        if (skin != null && move.type == TeraType.NORMAL) {
            return move.copy(type = skin)
        }
        // うるおいボイス
        if (
            context.attackerAbility == AbilityId("LiquidVoice") &&
            MoveFlag.SOUND in move.original.flags
        ) {
            return move.copy(type = TeraType.WATER)
        }
        return move
    }

    private fun weatherBall(
        context: DamageContext,
        move: EffectiveMove,
    ): EffectiveMove {
        // ばんのうがさ
        val umbrella = context.attackerItem == ItemId("UtilityUmbrella")
        val megaSol = context.attackerAbility == AbilityId("MegaSol")
        val umbrellaBlocks = umbrella && context.weather in sunOrRain
        // Mega Sol中のばんのうがさは、タイプにだけ元の砂・雪を反映する
        val typeWeather =
            if (
                umbrella &&
                megaSol &&
                context.weather == Weather.SUNLIGHT &&
                context.field.weather in sandOrSnow
            ) {
                context.field.weather
            } else {
                context.weather
            }
        val type =
            if (umbrella && typeWeather in sunOrRain) {
                TeraType.NORMAL
            } else {
                typeWeather?.weatherBallType ?: move.type
            }
        val doubles = context.weather != null && (!umbrellaBlocks || megaSol)
        val power = if (doubles) move.power * 2 else move.power
        return move.copy(type = type, power = power)
    }

    private val sunOrRain = setOf(Weather.SUNLIGHT, Weather.RAIN)
    private val sandOrSnow = setOf(Weather.SANDSTORM, Weather.SNOW)
}
