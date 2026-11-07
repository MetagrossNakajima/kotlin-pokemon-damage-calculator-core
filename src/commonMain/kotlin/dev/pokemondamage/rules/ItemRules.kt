package dev.pokemondamage.rules

import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.TeraType

internal object ItemRules {
    private val resistBerries =
        mapOf(
            ItemId("OccaBerry") to TeraType.FIRE,
            ItemId("PasshoBerry") to TeraType.WATER,
            ItemId("WacanBerry") to TeraType.ELECTRIC,
            ItemId("RindoBerry") to TeraType.GRASS,
            ItemId("YacheBerry") to TeraType.ICE,
            ItemId("ChopleBerry") to TeraType.FIGHTING,
            ItemId("KebiaBerry") to TeraType.POISON,
            ItemId("ShucaBerry") to TeraType.GROUND,
            ItemId("CobaBerry") to TeraType.FLYING,
            ItemId("PayapaBerry") to TeraType.PSYCHIC,
            ItemId("TangaBerry") to TeraType.BUG,
            ItemId("ChartiBerry") to TeraType.ROCK,
            ItemId("KasibBerry") to TeraType.GHOST,
            ItemId("HabanBerry") to TeraType.DRAGON,
            ItemId("ColburBerry") to TeraType.DARK,
            ItemId("BabiriBerry") to TeraType.STEEL,
            ItemId("RoseliBerry") to TeraType.FAIRY,
            ItemId("ChilanBerry") to TeraType.NORMAL,
        )

    private val typeItems =
        mapOf(
            ItemId("BlankPlate") to TeraType.NORMAL,
            ItemId("FlamePlate") to TeraType.FIRE,
            ItemId("SplashPlate") to TeraType.WATER,
            ItemId("MeadowPlate") to TeraType.GRASS,
            ItemId("ZapPlate") to TeraType.ELECTRIC,
            ItemId("IciclePlate") to TeraType.ICE,
            ItemId("FistPlate") to TeraType.FIGHTING,
            ItemId("ToxicPlate") to TeraType.POISON,
            ItemId("EarthPlate") to TeraType.GROUND,
            ItemId("SkyPlate") to TeraType.FLYING,
            ItemId("MindPlate") to TeraType.PSYCHIC,
            ItemId("InsectPlate") to TeraType.BUG,
            ItemId("StonePlate") to TeraType.ROCK,
            ItemId("SpookyPlate") to TeraType.GHOST,
            ItemId("DracoPlate") to TeraType.DRAGON,
            ItemId("DreadPlate") to TeraType.DARK,
            ItemId("IronPlate") to TeraType.STEEL,
            ItemId("PixiePlate") to TeraType.FAIRY,
            ItemId("SilkScarf") to TeraType.NORMAL,
            ItemId("Charcoal") to TeraType.FIRE,
            ItemId("MysticWater") to TeraType.WATER,
            ItemId("MiracleSeed") to TeraType.GRASS,
            ItemId("Magnet") to TeraType.ELECTRIC,
            ItemId("Never-MeltIce") to TeraType.ICE,
            ItemId("BlackBelt") to TeraType.FIGHTING,
            ItemId("PoisonBarb") to TeraType.POISON,
            ItemId("SoftSand") to TeraType.GROUND,
            ItemId("SharpBeak") to TeraType.FLYING,
            ItemId("TwistedSpoon") to TeraType.PSYCHIC,
            ItemId("SilverPowder") to TeraType.BUG,
            ItemId("HardStone") to TeraType.ROCK,
            ItemId("SpellTag") to TeraType.GHOST,
            ItemId("DragonFang") to TeraType.DRAGON,
            ItemId("BlackGlasses") to TeraType.DARK,
            ItemId("MetalCoat") to TeraType.STEEL,
            ItemId("FairyFeather") to TeraType.FAIRY,
        )

    fun resistType(item: ItemId?): TeraType? = resistBerries[item]

    fun boostType(item: ItemId?): TeraType? = typeItems[item]

    fun plateType(item: ItemId?): TeraType? {
        if (item == null) {
            return null
        }
        return if (item.value.endsWith("Plate")) typeItems[item] else null
    }
}
