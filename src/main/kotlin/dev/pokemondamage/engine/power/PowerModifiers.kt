package dev.pokemondamage.engine.power

import dev.pokemondamage.engine.DamageContext
import dev.pokemondamage.engine.TypeEffectiveness
import dev.pokemondamage.math.ModifierChain
import dev.pokemondamage.model.*
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.ItemRules

/** Ordered power modifiers; activation conditions remain the caller's responsibility. */
internal object PowerModifiers {
    fun calculate(context: DamageContext, unmodifiedPower: Long): ModifierChain {
        val attacker = context.attacker
        val defender = context.defender
        val ability = context.attackerAbility?.value.orEmpty()
        val defenderAbility = context.defenderAbility?.value.orEmpty()
        val item = context.attackerItem?.value.orEmpty()
        val move = context.move.original.id.value
        val type = context.move.type
        val flags = context.move.flags
        val effects = context.field.effects
        val terrain = context.field.terrain
        val physical = context.physical
        return ModifierChain("power", ModifierStage.POWER_MODIFIER).apply {
            add(
                move,
                8192,
                move == "Facade" && attacker.status in facadeStatuses ||
                    move == "Brine" && defender.hp <= defender.stats.hp / 2,
            )
            add(
                "ExpandingForce",
                6144,
                move == "ExpandingForce" && terrain == Terrain.PSYCHIC && context.attackerGrounded,
            )
            add(
                "KnockOff",
                6144,
                move == "KnockOff" &&
                    defender.item != null &&
                    !defender.itemConsumed &&
                    defender.flags[PokemonFlag.ITEM_REMOVABLE] != false,
            )
            add("GravApple", 6144, move == "GravApple" && context.field.gravity)
            add(
                "Solar",
                2048,
                move in solarMoves &&
                    context.weather != null &&
                    context.weather != Weather.SUNLIGHT,
            )
            add(move, 5461, move in collisionMoves && TypeEffectiveness.typeMultiplier(context) > 1)
            add("HelpingHand", 6144, FieldEffect.HELPING_HAND in effects)
            add("Terrain", 5325, context.attackerGrounded && terrainTypes[terrain] == type)
            add(
                "MistyTerrain",
                2048,
                terrain == Terrain.MISTY && type == TeraType.DRAGON && context.defenderGrounded,
            )
            add(
                "GrassyTerrain",
                2048,
                terrain == Terrain.GRASS && move in grassyMoves && context.defenderGrounded,
            )
            add("Technician", 6144, ability == "Technician" && unmodifiedPower <= 60)
            add("FlareBoost", 6144, ability == "FlareBoost" && !physical)
            add("ToxicBoost", 6144, ability == "ToxicBoost" && physical)
            add("StrongJaw", 6144, ability == "StrongJaw" && MoveFlag.BITE in flags)
            add("MegaLauncher", 6144, ability == "MegaLauncher" && MoveFlag.PULSE in flags)
            add("SteelySpirit", 6144, ability == "SteelySpirit" && type == TeraType.STEEL)
            add("Sharpness", 6144, ability == "Sharpness" && MoveFlag.SHARPNESS in flags)
            add(
                "Charge",
                8192,
                type == TeraType.ELECTRIC && attacker.flags[PokemonFlag.CHARGE] == true,
            )
            addAura(this, context)
            add("SheerForce", 5325, ability == "SheerForce" && MoveFlag.SHEER_FORCE in flags)
            add("SandForce", 5325, ability == "SandForce" && type in sandTypes)
            add("Analytic", 5325, ability == "Analytic")
            add("ToughClaws", 5325, ability == "ToughClaws" && context.contact)
            add("PunkRock", 5325, ability == "PunkRock" && MoveFlag.SOUND in flags)
            add("Battery", 5325, FieldEffect.BATTERY in effects && !physical)
            add("PowerSpot", 5325, FieldEffect.POWER_SPOT in effects)
            add(
                "Rivalry",
                if (attacker.profile.gender == defender.profile.gender) 5120 else 3072,
                ability == "Rivalry" &&
                    attacker.profile.gender != Gender.GENDERLESS &&
                    defender.profile.gender != Gender.GENDERLESS,
            )
            addSkin(this, context)
            add("IronFist", 4915, ability == "IronFist" && MoveFlag.PUNCH in flags)
            add("Reckless", 4915, ability == "Reckless" && MoveFlag.RECOIL in flags)
            add("DrySkin", 5120, defenderAbility == "DrySkin" && type == TeraType.FIRE)
            add(
                "SupremeOverlord",
                overlord[minOf(5, attacker.faintedAllies)],
                ability == "SupremeOverlord" && attacker.faintedAllies > 0,
            )
            add("NormalGem", 5325, item == "NormalGem" && type == TeraType.NORMAL)
            add("MuscleBand", 4505, item == "MuscleBand" && physical)
            add("WiseGlasses", 4505, item == "WiseGlasses" && !physical)
            add("PunchingGlove", 4506, item == "PunchingGlove" && MoveFlag.PUNCH in flags)
            add(item, 4915, ItemRules.boostType(context.attackerItem) == type)
            addSpeciesItem(this, context)
            add("Psyblade", 6144, move == "Psyblade" && terrain == Terrain.ELECTRIC)
            add(
                "RisingVoltage",
                8192,
                move == "RisingVoltage" && terrain == Terrain.ELECTRIC && context.defenderGrounded,
            )
            add("MudSport", 1352, FieldEffect.MUD_SPORT in effects && type == TeraType.ELECTRIC)
            add("WaterSport", 1352, FieldEffect.WATER_SPORT in effects && type == TeraType.FIRE)
        }
    }

    private fun addAura(chain: ModifierChain, context: DamageContext) {
        val aura =
            when (context.move.type) {
                TeraType.FAIRY -> AbilityId("FairyAura")
                TeraType.DARK -> AbilityId("DarkAura")
                else -> return
            }
        val effect =
            if (context.move.type == TeraType.FAIRY) FieldEffect.FAIRY_AURA
            else FieldEffect.DARK_AURA
        val active =
            context.attackerAbility == aura ||
                context.activeDefenderAbility == aura ||
                effect in context.field.effects
        val broken =
            context.attackerAbility == AbilityId("AuraBreak") ||
                context.defenderAbility == AbilityId("AuraBreak") ||
                FieldEffect.AURA_BREAK in context.field.effects
        chain.add(if (broken) "AuraBreak" else aura.value, if (broken) 3072 else 5448, active)
    }

    private fun addSkin(chain: ModifierChain, context: DamageContext) {
        val move = context.move.original
        val convertible =
            move.id != MoveId("Judgment") &&
                move.id != MoveId("WeatherBall") &&
                !(move.id == MoveId("TerrainPulse") && context.field.terrain != null) &&
                !(move.id == MoveId("TeraBlast") && context.attacker.teraType != null)
        val converted =
            context.attackerAbility == AbilityId("Normalize") ||
                (AbilityRules.skinType(context.attackerAbility) != null &&
                    move.type == PokemonType.NORMAL &&
                    context.move.type == AbilityRules.skinType(context.attackerAbility))
        chain.add(context.attackerAbility?.value.orEmpty(), 4915, convertible && converted)
    }

    private fun addSpeciesItem(chain: ModifierChain, context: DamageContext) {
        val item = context.attackerItem?.value ?: return
        val rule = speciesItems[item] ?: return
        chain.add(
            item,
            4915,
            context.attacker.profile.id.value in rule.first && context.move.type in rule.second,
        )
    }

    private val facadeStatuses = setOf(Status.BURN, Status.POISON, Status.TOXIC, Status.PARALYSIS)
    private val solarMoves = setOf("SolarBeam", "SolarBlade")
    private val collisionMoves = setOf("CollisionCourse", "ElectroDrift")
    private val grassyMoves = setOf("Earthquake", "Bulldoze")
    private val sandTypes = setOf(TeraType.GROUND, TeraType.ROCK, TeraType.STEEL)
    private val terrainTypes =
        mapOf(
            Terrain.ELECTRIC to TeraType.ELECTRIC,
            Terrain.GRASS to TeraType.GRASS,
            Terrain.PSYCHIC to TeraType.PSYCHIC,
        )
    private val overlord = listOf(4096, 4506, 4915, 5325, 5734, 6144)
    private val speciesItems = buildMap {
        val dialga = setOf("Dialga", "Dialga-Origin") to setOf(TeraType.STEEL, TeraType.DRAGON)
        val palkia = setOf("Palkia", "Palkia-Origin") to setOf(TeraType.WATER, TeraType.DRAGON)
        val giratina =
            setOf("Giratina", "Giratina-Origin") to setOf(TeraType.GHOST, TeraType.DRAGON)
        put("AdamantOrb", dialga)
        put("AdamantCrystal", dialga)
        put("LustrousOrb", palkia)
        put("LustrousGlobe", palkia)
        put("GriseousOrb", giratina)
        put("GriseousCore", giratina)
        put("SoulDew", setOf("Latias", "Latios") to setOf(TeraType.PSYCHIC, TeraType.DRAGON))
    }
}
