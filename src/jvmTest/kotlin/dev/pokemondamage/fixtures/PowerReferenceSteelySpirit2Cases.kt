package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.Stats

// Fixed reference expectations for SteelySpirit. See PowerReferenceCases for provenance.
internal fun powerReferenceSteelySpirit2Cases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceSteelySpirit2CasesPart1())
    }

private fun powerReferenceSteelySpirit2CasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1008/SteelySpirit/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("SteelySpirit"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(
                            MoveFlag.BITE,
                            MoveFlag.PULSE,
                            MoveFlag.SHARPNESS,
                            MoveFlag.CONTACT,
                            MoveFlag.SOUND,
                            MoveFlag.PUNCH,
                            MoveFlag.SHEER_FORCE,
                            MoveFlag.RECOIL,
                        ),
                ),
            effects =
                EnumFlags(FieldEffect.HELPING_HAND, FieldEffect.BATTERY, FieldEffect.POWER_SPOT),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )
