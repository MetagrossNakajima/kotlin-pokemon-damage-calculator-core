package dev.pokemondamage.engine

import dev.pokemondamage.model.*
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.BattleEffects

/** Immutable per-hit resolution. Suppression is resolved before move transformations. */
internal class DamageContext(val request: DamageRequest) {
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
    val move = MovePreparation.prepare(this)

    val physical: Boolean
        get() = move.category == Category.PHYSICAL

    val physicalDefense: Boolean
        get() = physical || request.move.id.value in physicalDefenseMoves

    val unnerve: Boolean
        get() = FieldEffect.UNNERVE in this.field.effects || attackerAbility in berryBlockers

    val contact: Boolean
        get() =
            MoveFlag.CONTACT in move.flags &&
                attackerAbility != AbilityId("LongReach") &&
                !(attackerItem == ItemId("PunchingGlove") && MoveFlag.PUNCH in move.flags)

    private fun resolveDefenderAbility(): AbilityId? {
        if (defenderItem == ItemId("AbilityShield")) return activeDefenderAbility
        val ignores =
            attackerAbility in moldBreakers || request.move.id.value in abilityIgnoringMoves
        return if (ignores && AbilityRules.canIgnore(activeDefenderAbility)) null
        else activeDefenderAbility
    }

    private fun resolveWeather(): Weather? {
        val abilities = listOf(attackerAbility, activeDefenderAbility)
        if (attackerAbility == AbilityId("MegaSol") && !BattleEffects.weatherSuppressed(abilities))
            return Weather.SUNLIGHT
        return BattleEffects.weather(field, abilities)
    }

    private companion object {
        private val moldBreakers =
            setOf(AbilityId("MoldBreaker"), AbilityId("Teravolt"), AbilityId("Turboblaze"))
        private val abilityIgnoringMoves = setOf("SunsteelStrike", "MoongeistBeam", "PhotonGeyser")
        private val physicalDefenseMoves = setOf("Psyshock", "Psystrike", "SecretSword")
        private val berryBlockers =
            setOf(AbilityId("Unnerve"), AbilityId("AsOneGlastrier"), AbilityId("AsOneSpectrier"))
    }
}
