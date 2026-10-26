package dev.pokemondamage.engine

import dev.pokemondamage.math.BattleMath
import dev.pokemondamage.model.*
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.ItemRules

/** Resolves type, power, category and contact in the order required by each move. */
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
        return if (original.id == MoveId("PhotonGeyser"))
            prepared.copy(category = adaptiveCategory(context.attacker))
        else prepared
    }

    private fun adaptiveCategory(pokemon: PokemonState): Category =
        if (
            BattleMath.rankedStat(pokemon.stats.attack, pokemon.stages.attack) >
                BattleMath.rankedStat(pokemon.stats.specialAttack, pokemon.stages.specialAttack)
        )
            Category.PHYSICAL
        else Category.SPECIAL

    private fun specific(context: DamageContext, move: EffectiveMove): EffectiveMove? {
        val attacker = context.attacker
        return when (move.original.id.value) {
            "Judgment" -> move.copy(type = ItemRules.plateType(context.attackerItem) ?: move.type)
            "IvyCudgel" ->
                ability(context, move.copy(type = ivyCudgelType(attacker.profile.id, move.type)))
            "ShellSideArm" -> shellSideArm(context, ability(context, move))
            "TeraBlast" ->
                attacker.teraType?.let {
                    move.copy(
                        type = it,
                        power = if (it == TeraType.STELLAR) 100 else 80,
                        category = adaptiveCategory(attacker),
                    )
                }
            "TeraStarstorm" ->
                if (attacker.profile.id == PokemonId("Terapagos-Stellar")) {
                    move.copy(
                        type = TeraType.STELLAR,
                        category =
                            if (attacker.teraType != null) adaptiveCategory(attacker)
                            else move.category,
                    )
                } else null
            "WeatherBall" -> weatherBall(context, move)
            "TerrainPulse" ->
                context.field.terrain
                    ?.takeIf { context.attackerGrounded }
                    ?.let {
                        move.copy(
                            type =
                                when (it) {
                                    Terrain.ELECTRIC -> TeraType.ELECTRIC
                                    Terrain.GRASS -> TeraType.GRASS
                                    Terrain.MISTY -> TeraType.FAIRY
                                    Terrain.PSYCHIC -> TeraType.PSYCHIC
                                },
                            power = move.power * 2,
                        )
                    }
            "RagingBull" ->
                move.copy(
                    type =
                        if (context.attackerAbility == AbilityId("Normalize")) TeraType.NORMAL
                        else
                            when (attacker.profile.id.value) {
                                "Tauros-Paldea-Combat" -> TeraType.FIGHTING
                                "Tauros-Paldea-Blaze" -> TeraType.FIRE
                                "Tauros-Paldea-Aqua" -> TeraType.WATER
                                else -> move.type
                            },
                )
            else -> null
        }
    }

    private fun ivyCudgelType(id: PokemonId, fallback: TeraType): TeraType =
        when {
            id.value == "Ogerpon" || id.value.startsWith("Ogerpon-Teal") -> TeraType.GRASS
            id.value.startsWith("Ogerpon-Cornerstone") -> TeraType.ROCK
            id.value.startsWith("Ogerpon-Hearthflame") -> TeraType.FIRE
            id.value.startsWith("Ogerpon-Wellspring") -> TeraType.WATER
            else -> fallback
        }

    private fun shellSideArm(context: DamageContext, move: EffectiveMove): EffectiveMove {
        val attacker = context.attacker
        val defender = context.defender
        val wonderRoom = FieldEffect.WONDER_ROOM in context.field.effects
        // Reference swaps raw defenses, applies their stages, then swaps the comparison operands.
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
        // Cross multiplication preserves exact ties and also handles a ranked stat rounded to zero.
        val physical = attack.toLong() * specialDefense > specialAttack.toLong() * defense
        val flags =
            if (physical) move.flags.values + MoveFlag.CONTACT
            else move.flags.values - MoveFlag.CONTACT
        return move.copy(
            category = if (physical) Category.PHYSICAL else Category.SPECIAL,
            flags = EnumFlags(*flags.toTypedArray()),
        )
    }

    private fun ability(context: DamageContext, move: EffectiveMove): EffectiveMove {
        if (context.attackerAbility == AbilityId("Normalize"))
            return move.copy(type = TeraType.NORMAL)
        val skin = AbilityRules.skinType(context.attackerAbility)
        if (skin != null && move.type == TeraType.NORMAL) return move.copy(type = skin)
        if (
            context.attackerAbility == AbilityId("LiquidVoice") &&
                MoveFlag.SOUND in move.original.flags
        )
            return move.copy(type = TeraType.WATER)
        return move
    }

    private fun weatherBall(context: DamageContext, move: EffectiveMove): EffectiveMove {
        val umbrella = context.attackerItem == ItemId("UtilityUmbrella")
        val megaSol = context.attackerAbility == AbilityId("MegaSol")
        val umbrellaBlocks = umbrella && context.weather in sunOrRain
        // Under Mega Sol, the umbrella restores actual sand/snow for the type but not the power.
        val typeWeather =
            if (
                umbrella &&
                    megaSol &&
                    context.weather == Weather.SUNLIGHT &&
                    context.field.weather in sandOrSnow
            ) {
                context.field.weather
            } else context.weather
        val type =
            if (umbrella && typeWeather in sunOrRain) TeraType.NORMAL
            else
                when (typeWeather) {
                    Weather.SUNLIGHT -> TeraType.FIRE
                    Weather.RAIN -> TeraType.WATER
                    Weather.SANDSTORM -> TeraType.ROCK
                    Weather.SNOW -> TeraType.ICE
                    null -> move.type
                }
        val doubles = context.weather != null && (!umbrellaBlocks || megaSol)
        return move.copy(type = type, power = move.power * if (doubles) 2 else 1)
    }

    private val sunOrRain = setOf(Weather.SUNLIGHT, Weather.RAIN)
    private val sandOrSnow = setOf(Weather.SANDSTORM, Weather.SNOW)
}
