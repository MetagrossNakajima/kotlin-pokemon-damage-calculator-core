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

// Fixed reference expectations for ToughClaws. See PowerReferenceCases for provenance.
internal fun powerReferenceToughClaws2Cases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceToughClaws2CasesPart1())
    }

private fun powerReferenceToughClaws2CasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1728/ToughClaws/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
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
            expectedMultiplier = 13501,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )
