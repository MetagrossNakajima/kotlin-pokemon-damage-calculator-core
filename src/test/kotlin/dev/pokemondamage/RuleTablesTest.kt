package dev.pokemondamage

import dev.pokemondamage.model.*
import dev.pokemondamage.rules.AbilityRules
import dev.pokemondamage.rules.ItemRules
import kotlin.test.*

class RuleTablesTest {
    @Test
    fun `resistance berries cover all eighteen types with exact associations`() {
        val berries =
            listOf(
                "Chilan",
                "Occa",
                "Passho",
                "Wacan",
                "Rindo",
                "Yache",
                "Chople",
                "Kebia",
                "Shuca",
                "Coba",
                "Payapa",
                "Tanga",
                "Charti",
                "Kasib",
                "Haban",
                "Colbur",
                "Babiri",
                "Roseli",
            )
        for ((type, berry) in PokemonType.entries.zip(berries)) {
            assertEquals(
                TeraType.valueOf(type.name),
                ItemRules.resistType(ItemId("${berry}Berry")),
                berry,
            )
        }
        assertNull(ItemRules.resistType(null))
        assertNull(ItemRules.resistType(ItemId("SitrusBerry")))
    }

    @Test
    fun `plates and ordinary type items cover all eighteen types`() {
        val plates =
            listOf(
                "Blank",
                "Flame",
                "Splash",
                "Zap",
                "Meadow",
                "Icicle",
                "Fist",
                "Toxic",
                "Earth",
                "Sky",
                "Mind",
                "Insect",
                "Stone",
                "Spooky",
                "Draco",
                "Dread",
                "Iron",
                "Pixie",
            )
        val items =
            listOf(
                "SilkScarf",
                "Charcoal",
                "MysticWater",
                "Magnet",
                "MiracleSeed",
                "Never-MeltIce",
                "BlackBelt",
                "PoisonBarb",
                "SoftSand",
                "SharpBeak",
                "TwistedSpoon",
                "SilverPowder",
                "HardStone",
                "SpellTag",
                "DragonFang",
                "BlackGlasses",
                "MetalCoat",
                "FairyFeather",
            )
        for ((index, type) in PokemonType.entries.withIndex()) {
            assertEquals(
                TeraType.valueOf(type.name),
                ItemRules.boostType(ItemId("${plates[index]}Plate")),
            )
            assertEquals(TeraType.valueOf(type.name), ItemRules.boostType(ItemId(items[index])))
        }
        assertNull(ItemRules.boostType(null))
        assertNull(ItemRules.boostType(ItemId("LifeOrb")))
    }

    @Test
    fun `mold breaker list includes source abilities and excludes protected abilities`() {
        val names =
            "ArmorTail AromaVeil AuraBreak BattleArmor BigPecks Bulletproof " +
                "ClearBody Contrary Damp Dazzling Disguise DrySkin EarthEater Eelevate " +
                "Filter FlashFire FlowerGift FlowerVeil Fluffy FriendGuard FurCoat " +
                "GoodasGold GrassPelt GuardDog Heatproof HeavyMetal HyperCutter IceFace " +
                "IceScales Illuminate Immunity InnerFocus Insomnia KeenEye LeafGuard " +
                "Levitate LightMetal LightningRod Limber MagicBounce MagmaArmor " +
                "MarvelScale MindsEye MirrorArmor MotorDrive Multiscale Oblivious " +
                "Overcoat OwnTempo PastelVeil PunkRock PurifyingSalt QueenlyMajesty " +
                "SandVeil SapSipper ShellArmor ShieldDust Simple SnowCloak SolidRock " +
                "Soundproof StickyHold StormDrain Sturdy SuctionCups SweetVeil " +
                "TangledFeet Telepathy TeraShell ThermalExchange ThickFat Unaware " +
                "VitalSpirit VoltAbsorb WaterAbsorb WaterBubble WaterVeil WellBakedBody " +
                "WhiteSmoke WindRider WonderGuard WonderSkin"
        for (name in names.split(' ')) assertTrue(AbilityRules.canIgnore(AbilityId(name)), name)
        for (name in listOf("ShadowShield", "FullMetalBody", "PrismArmor", "Unknown")) assertFalse(
            AbilityRules.canIgnore(AbilityId(name)),
            name,
        )
        assertFalse(AbilityRules.canIgnore(null))
        assertNull(AbilityRules.skinType(null))
        assertNull(AbilityRules.skinType(AbilityId("Normalize")))
    }
}
