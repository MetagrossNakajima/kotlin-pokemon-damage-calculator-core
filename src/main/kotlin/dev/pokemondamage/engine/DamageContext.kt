package dev.pokemondamage.engine

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.DamageRequest
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.Weather
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.BattleEffects

/** 1発分の計算条件。特性・持ち物の無効判定を技の変化より先に解決する。 */
internal class DamageContext(
    val request: DamageRequest,
    moveOverride: EffectiveMove? = null,
) {
    val attacker = request.attacker
    val defender = request.defender
    val field = request.field
    val attackerAbility = BattleEffects.ability(attacker, field, defender)
    val activeDefenderAbility = BattleEffects.ability(defender, field, attacker)
    val attackerItem = BattleEffects.item(attacker, field, defender)
    val defenderItem = BattleEffects.item(defender, field, attacker)
    val defenderAbility = resolveDefenderAbility()
    val weather = resolveWeather()
    val attackerGrounded = BattleEffects.isGrounded(attacker, field, attackerAbility, attackerItem)
    val defenderGrounded = BattleEffects.isGrounded(defender, field, defenderAbility, defenderItem)
    val defenderTypes = BattleEffects.currentTypes(defender)
    val move = moveOverride ?: MovePreparation.prepare(this)

    val physical: Boolean
        get() = move.category == Category.PHYSICAL

    val physicalDefense: Boolean
        get() = physical || request.move.id.value in physicalDefenseMoves

    val unnerve: Boolean
        get() = FieldEffect.UNNERVE in this.field.effects || attackerAbility in berryBlockers

    // えんかく･パンチグローブ
    val contact: Boolean
        get() =
            MoveFlag.CONTACT in move.flags &&
                attackerAbility != AbilityId("LongReach") &&
                !(attackerItem == ItemId("PunchingGlove") && MoveFlag.PUNCH in move.flags)

    private fun resolveDefenderAbility(): AbilityId? {
        // とくせいガード
        if (defenderItem == ItemId("AbilityShield")) {
            return activeDefenderAbility
        }
        // かたやぶり系特性･特性を無視する技
        val ignores =
            attackerAbility in moldBreakers || request.move.id.value in abilityIgnoringMoves
        return if (ignores && AbilityRules.canIgnore(activeDefenderAbility)) {
            null
        } else {
            activeDefenderAbility
        }
    }

    private fun resolveWeather(): Weather? {
        val abilities = listOf(attackerAbility, activeDefenderAbility)
        if (
            attackerAbility == AbilityId("MegaSol") && !BattleEffects.weatherSuppressed(abilities)
        ) {
            return Weather.SUNLIGHT
        }
        return BattleEffects.weather(field, abilities)
    }

    private companion object {
        // かたやぶり･テラボルテージ･ターボブレイズ
        private val moldBreakers =
            setOf(AbilityId("MoldBreaker"), AbilityId("Teravolt"), AbilityId("Turboblaze"))

        // メテオドライブ･シャドーレイ･フォトンゲイザー
        private val abilityIgnoringMoves = setOf("SunsteelStrike", "MoongeistBeam", "PhotonGeyser")

        // サイコショック･サイコブレイク･しんぴのつるぎ
        private val physicalDefenseMoves = setOf("Psyshock", "Psystrike", "SecretSword")

        // きんちょうかん･じんばいったい
        private val berryBlockers =
            setOf(AbilityId("Unnerve"), AbilityId("AsOneGlastrier"), AbilityId("AsOneSpectrier"))
    }
}
