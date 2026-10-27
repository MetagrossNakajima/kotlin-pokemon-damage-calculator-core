package dev.pokemondamage.engine

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.TeraType
import dev.pokemondamage.rules.TypeChart

/** タイプ相性の例外と、特性・持ち物による無効判定やテラスシェルを分けて処理する。 */
internal object TypeEffectiveness {
    fun typeMultiplier(context: DamageContext): Double {
        // ステラ技はテラスタルした相手に効果抜群
        val attackType =
            context.move.type.pokemonType
                ?: return if (context.defender.teraType == null) 1.0 else 2.0
        val moveId = context.move.original.id.value
        val result =
            context.defenderTypes.toList().fold(1.0) { multiplier, type ->
                val chartFactor = TypeChart.effectiveness(attackType, type)
                // じゅうりょく･接地状態によるひこうの無効解除
                val groundedFlying =
                    attackType == PokemonType.GROUND &&
                        type == PokemonType.FLYING &&
                        (
                            context.field.gravity ||
                                context.defender.flags[PokemonFlag.GROUNDED] == true
                        )
                // きもったま･しんがん
                val revealedGhost =
                    context.attackerAbility in ghostRevealingAbilities &&
                        attackType in ghostBlockedTypes && type == PokemonType.GHOST
                val factor =
                    when {
                        // フリーズドライ
                        moveId == "FreezeDry" && type == PokemonType.WATER -> 2.0

                        groundedFlying || revealedGhost -> 1.0

                        // ねらいのまと
                        chartFactor == 0.0 && context.defenderItem == ItemId("RingTarget") -> 1.0

                        else -> chartFactor
                    }
                val combined = multiplier * factor
                // フライングプレス
                if (moveId == "FlyingPress") {
                    combined * TypeChart.effectiveness(PokemonType.FLYING, type)
                } else {
                    combined
                }
            }
        // くろいてっきゅう･サウザンアローは、複合タイプ計算後の無効を等倍にする
        if (
            result == 0.0 &&
            attackType == PokemonType.GROUND &&
            (context.defenderItem == ItemId("IronBall") || moveId == "ThousandArrows")
        ) {
            return 1.0
        }
        return result
    }

    fun calculate(context: DamageContext): Double {
        val type = context.move.type
        val ability = context.defenderAbility
        val typeMultiplier = typeMultiplier(context)
        // テラスシェル
        val result =
            if (typeMultiplier != 0.0 && ability == AbilityId("TeraShell")) {
                0.5
            } else {
                typeMultiplier
            }
        // 浮遊特性･ふうせん（サウザンアローは対象外）
        val airborneImmunity =
            type == TeraType.GROUND &&
                context.move.original.id != MoveId("ThousandArrows") &&
                !context.defenderGrounded &&
                (ability in levitation || context.defenderItem == ItemId("AirBalloon"))
        val typeImmunity =
            when (type) {
                // どしょく
                TeraType.GROUND -> ability == AbilityId("EarthEater")

                // もらいび･こんがりボディ
                TeraType.FIRE -> ability in fireAbsorbers

                // ちょすい･よびみず･かんそうはだ
                TeraType.WATER -> ability in waterAbsorbers

                // ちくでん･ひらいしん･でんきエンジン
                TeraType.ELECTRIC -> ability in electricAbsorbers

                // そうしょく
                TeraType.GRASS -> ability == AbilityId("SapSipper")

                else -> false
            }
        val flags = context.move.flags
        // ぼうおん･ぼうだん･かぜのり
        val traitImmunity =
            (MoveFlag.SOUND in flags && ability == AbilityId("Soundproof")) ||
                (MoveFlag.BULLET in flags && ability == AbilityId("Bulletproof")) ||
                (MoveFlag.WIND in flags && ability == AbilityId("WindRider"))
        return if (
            airborneImmunity ||
            typeImmunity ||
            traitImmunity ||
            // ふしぎなまもり
            (ability == AbilityId("WonderGuard") && result <= 1.0)
        ) {
            0.0
        } else {
            result
        }
    }

    private val ghostRevealingAbilities = setOf(AbilityId("Scrappy"), AbilityId("MindsEye"))
    private val ghostBlockedTypes = setOf(PokemonType.NORMAL, PokemonType.FIGHTING)
    private val levitation = setOf(AbilityId("Levitate"), AbilityId("Eelevate"))
    private val fireAbsorbers = setOf(AbilityId("FlashFire"), AbilityId("WellBakedBody"))
    private val waterAbsorbers =
        setOf(AbilityId("WaterAbsorb"), AbilityId("StormDrain"), AbilityId("DrySkin"))
    private val electricAbsorbers =
        setOf(AbilityId("VoltAbsorb"), AbilityId("LightningRod"), AbilityId("MotorDrive"))
}
