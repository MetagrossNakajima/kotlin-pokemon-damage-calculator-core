package dev.pokemondamage

import dev.pokemondamage.model.Category
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.rules.MoveRules
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoveRulesTest {
    @Test
    fun `all fourteen fixed damage moves accept zero metadata power`() {
        val moves =
            listOf(
                "SuperFang",
                "NaturesMadness",
                "Ruination",
                "GuardianofAlola",
                "FinalGambit",
                "Endeavor",
                "SonicBoom",
                "DragonRage",
                "SeismicToss",
                "NightShade",
                "Fissure",
                "SheerCold",
                "HornDrill",
                "Guillotine",
            )
        for (name in moves) {
            val id = MoveId(name)
            assertTrue(MoveRules.isFixedDamage(id), name)
            assertEquals(0, Move(id, PokemonType.NORMAL, 0, Category.PHYSICAL).power, name)
        }
        assertFalse(MoveRules.isFixedDamage(MoveId("Tackle")))
    }

    @Test
    fun `guaranteed critical moves are classified by ID`() {
        for (
        name in
        listOf("WickedBlow", "FlowerTrick", "FrostBreath", "StormThrow", "SurgingStrikes")
        ) {
            assertTrue(MoveRules.isGuaranteedCritical(MoveId(name)), name)
        }
        assertFalse(MoveRules.isGuaranteedCritical(MoveId("Slash")))
    }

    @Test
    fun `all natural multihit moves are classified for parental bond exclusion`() {
        for (
        name in
        listOf(
            "DoubleKick",
            "SurgingStrikes",
            "DoubleHit",
            "Bonemerang",
            "DoubleIronBash",
            "DragonDarts",
            "DualChop",
            "DualWingbeat",
            "GearGrind",
            "Twineedle",
            "TwinBeam",
            "TripleDive",
            "BulletSeed",
            "RockBlast",
            "IcicleSpear",
            "PinMissile",
            "TailSlap",
            "ArmThrust",
            "Barrage",
            "BoneRush",
            "CometPunch",
            "DoubleSlap",
            "FuryAttack",
            "FurySwipes",
            "SpikeCannon",
            "WaterShuriken",
            "ScaleShot",
            "TripleAxel",
            "TripleKick",
            "PopulationBomb",
        )
        ) {
            assertTrue(MoveRules.isNaturalMultiHit(MoveId(name)), name)
        }
        assertFalse(MoveRules.isNaturalMultiHit(MoveId("Tackle")))
    }

    @Test
    fun `weight based moves are distinguished from ordinary attacks`() {
        for (name in listOf("LowKick", "GrassKnot", "HeavySlam", "HeatCrash")) {
            assertTrue(MoveRules.isWeightBased(MoveId(name)), name)
        }
        assertFalse(MoveRules.isWeightBased(MoveId("BodySlam")))
    }

    @Test
    fun `source unsupported moves remain explicitly identifiable`() {
        for (
        name in
        listOf("Counter", "Bide", "Comeuppance", "MirrorCoat", "MetalBurst", "Psywave")
        ) {
            assertTrue(MoveRules.isUnsupported(MoveId(name)), name)
        }
        assertFalse(MoveRules.isUnsupported(MoveId("Tackle")))
    }
}
