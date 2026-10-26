package dev.pokemondamage.engine

import dev.pokemondamage.model.*
import dev.pokemondamage.rules.TypeChart

/** Type-chart exceptions are separate from ability/item immunities and Tera Shell. */
internal object TypeEffectiveness {
    fun typeMultiplier(context: DamageContext): Double {
        val attackType =
            context.move.type.pokemonType
                ?: return if (context.defender.teraType == null) 1.0 else 2.0
        val moveId = context.move.original.id.value
        var result = 1.0
        for (type in context.defenderTypes.toList()) {
            var factor = TypeChart.effectiveness(attackType, type)
            if (
                attackType == PokemonType.GROUND &&
                    type == PokemonType.FLYING &&
                    (context.field.gravity || context.defender.flags[PokemonFlag.GROUNDED] == true)
            )
                factor = 1.0
            if (
                context.attackerAbility in ghostRevealingAbilities &&
                    attackType in ghostBlockedTypes &&
                    type == PokemonType.GHOST
            )
                factor = 1.0
            if (factor == 0.0 && context.defenderItem == ItemId("RingTarget")) factor = 1.0
            if (moveId == "FreezeDry" && type == PokemonType.WATER) factor = 2.0
            result *= factor
            if (moveId == "FlyingPress") result *= TypeChart.effectiveness(PokemonType.FLYING, type)
        }
        // Unlike Gravity, Iron Ball and Thousand Arrows neutralize the combined Flying immunity.
        if (
            result == 0.0 &&
                attackType == PokemonType.GROUND &&
                (context.defenderItem == ItemId("IronBall") || moveId == "ThousandArrows")
        )
            return 1.0
        return result
    }

    fun calculate(context: DamageContext): Double {
        val type = context.move.type
        val ability = context.defenderAbility
        var result = typeMultiplier(context)
        if (result != 0.0 && ability == AbilityId("TeraShell")) result = 0.5
        val airborneImmunity =
            type == TeraType.GROUND &&
                context.move.original.id != MoveId("ThousandArrows") &&
                !context.defenderGrounded &&
                (ability in levitation || context.defenderItem == ItemId("AirBalloon"))
        val typeImmunity =
            when (type) {
                TeraType.GROUND -> ability == AbilityId("EarthEater")
                TeraType.FIRE -> ability in fireAbsorbers
                TeraType.WATER -> ability in waterAbsorbers
                TeraType.ELECTRIC -> ability in electricAbsorbers
                TeraType.GRASS -> ability == AbilityId("SapSipper")
                else -> false
            }
        val flags = context.move.flags
        val traitImmunity =
            MoveFlag.SOUND in flags && ability == AbilityId("Soundproof") ||
                MoveFlag.BULLET in flags && ability == AbilityId("Bulletproof") ||
                MoveFlag.WIND in flags && ability == AbilityId("WindRider")
        return if (
            airborneImmunity ||
                typeImmunity ||
                traitImmunity ||
                ability == AbilityId("WonderGuard") && result <= 1.0
        )
            0.0
        else result
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
