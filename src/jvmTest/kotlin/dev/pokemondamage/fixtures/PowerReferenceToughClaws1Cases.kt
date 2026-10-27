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
internal fun powerReferenceToughClaws1Cases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceToughClaws1CasesPart1())
        addAll(powerReferenceToughClaws1CasesPart2())
        addAll(powerReferenceToughClaws1CasesPart3())
        addAll(powerReferenceToughClaws1CasesPart4())
        addAll(powerReferenceToughClaws1CasesPart5())
    }

private fun powerReferenceToughClaws1CasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1585/ToughClaws/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1586/ToughClaws/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1587/ToughClaws/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1588/ToughClaws/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1589/ToughClaws/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1590/ToughClaws/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1591/ToughClaws/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1592/ToughClaws/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1593/ToughClaws/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1594/ToughClaws/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1595/ToughClaws/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1596/ToughClaws/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1597/ToughClaws/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1598/ToughClaws/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1599/ToughClaws/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1600/ToughClaws/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
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
        PowerReferenceCase(
            name = "1601/ToughClaws/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 60, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1602/ToughClaws/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1603/ToughClaws/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 61, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1604/ToughClaws/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
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
        PowerReferenceCase(
            name = "1605/ToughClaws/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1606/ToughClaws/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1607/ToughClaws/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1608/ToughClaws/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = null,
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
        PowerReferenceCase(
            name = "1609/ToughClaws/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 66,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        PowerReferenceCase(
            name = "1610/ToughClaws/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 11422,
            expectedPower = 167,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1611/ToughClaws/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 67,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        PowerReferenceCase(
            name = "1612/ToughClaws/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 11422,
            expectedPower = 170,
            expectedDamage = listOf(32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1613/ToughClaws/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 66,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        PowerReferenceCase(
            name = "1614/ToughClaws/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 11422,
            expectedPower = 167,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
    )

private fun powerReferenceToughClaws1CasesPart2(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1615/ToughClaws/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 67,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        PowerReferenceCase(
            name = "1616/ToughClaws/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 11422,
            expectedPower = 170,
            expectedDamage = listOf(32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1617/ToughClaws/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 66,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        PowerReferenceCase(
            name = "1618/ToughClaws/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 11422,
            expectedPower = 167,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1619/ToughClaws/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 67,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
            expectedControlDamage =
                listOf(13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15),
        ),
        PowerReferenceCase(
            name = "1620/ToughClaws/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 11422,
            expectedPower = 170,
            expectedDamage = listOf(32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1621/ToughClaws/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1622/ToughClaws/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1623/ToughClaws/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1624/ToughClaws/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
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
        PowerReferenceCase(
            name = "1625/ToughClaws/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 60, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1626/ToughClaws/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1627/ToughClaws/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 61, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1628/ToughClaws/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
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
        PowerReferenceCase(
            name = "1629/ToughClaws/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1630/ToughClaws/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1631/ToughClaws/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1632/ToughClaws/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("MuscleBand"),
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
        PowerReferenceCase(
            name = "1633/ToughClaws/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1634/ToughClaws/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1635/ToughClaws/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1636/ToughClaws/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1637/ToughClaws/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1638/ToughClaws/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1639/ToughClaws/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1640/ToughClaws/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1641/ToughClaws/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1642/ToughClaws/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1643/ToughClaws/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1644/ToughClaws/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
    )

private fun powerReferenceToughClaws1CasesPart3(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1645/ToughClaws/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 66,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            expectedControlDamage =
                listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
        ),
        PowerReferenceCase(
            name = "1646/ToughClaws/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
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
            expectedMultiplier = 14849,
            expectedPower = 218,
            expectedDamage = listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1647/ToughClaws/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 67,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            expectedControlDamage =
                listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
        ),
        PowerReferenceCase(
            name = "1648/ToughClaws/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
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
            expectedMultiplier = 14849,
            expectedPower = 221,
            expectedDamage = listOf(84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1649/ToughClaws/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 60, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 66,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            expectedControlDamage =
                listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
        ),
        PowerReferenceCase(
            name = "1650/ToughClaws/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
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
            expectedMultiplier = 14849,
            expectedPower = 218,
            expectedDamage = listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1651/ToughClaws/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 61, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 67,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            expectedControlDamage =
                listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
        ),
        PowerReferenceCase(
            name = "1652/ToughClaws/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
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
            expectedMultiplier = 14849,
            expectedPower = 221,
            expectedDamage = listOf(84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1653/ToughClaws/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 66,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            expectedControlDamage =
                listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
        ),
        PowerReferenceCase(
            name = "1654/ToughClaws/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
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
            expectedMultiplier = 14849,
            expectedPower = 218,
            expectedDamage = listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1655/ToughClaws/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4505,
            expectedPower = 67,
            expectedDamage = listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
            expectedControlDamage =
                listOf(26, 26, 26, 27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31),
        ),
        PowerReferenceCase(
            name = "1656/ToughClaws/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("WiseGlasses"),
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
            expectedMultiplier = 14849,
            expectedPower = 221,
            expectedDamage = listOf(84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1657/ToughClaws/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1658/ToughClaws/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 8788,
            expectedPower = 129,
            expectedDamage = listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1659/ToughClaws/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1660/ToughClaws/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 8788,
            expectedPower = 131,
            expectedDamage = listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1661/ToughClaws/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1662/ToughClaws/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 8788,
            expectedPower = 129,
            expectedDamage = listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1663/ToughClaws/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1664/ToughClaws/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 8788,
            expectedPower = 131,
            expectedDamage = listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1665/ToughClaws/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1666/ToughClaws/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 8788,
            expectedPower = 129,
            expectedDamage = listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1667/ToughClaws/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1668/ToughClaws/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 8788,
            expectedPower = 131,
            expectedDamage = listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1669/ToughClaws/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1670/ToughClaws/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
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
            expectedMultiplier = 11425,
            expectedPower = 167,
            expectedDamage = listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1671/ToughClaws/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1672/ToughClaws/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
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
            expectedMultiplier = 11425,
            expectedPower = 170,
            expectedDamage = listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1673/ToughClaws/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 60, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1674/ToughClaws/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
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
            expectedMultiplier = 11425,
            expectedPower = 167,
            expectedDamage = listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
    )

private fun powerReferenceToughClaws1CasesPart4(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1675/ToughClaws/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 61, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1676/ToughClaws/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
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
            expectedMultiplier = 11425,
            expectedPower = 170,
            expectedDamage = listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1677/ToughClaws/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1678/ToughClaws/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
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
            expectedMultiplier = 11425,
            expectedPower = 167,
            expectedDamage = listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1679/ToughClaws/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1680/ToughClaws/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("PunchingGlove"),
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
            expectedMultiplier = 11425,
            expectedPower = 170,
            expectedDamage = listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1681/ToughClaws/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 5325,
            expectedPower = 78,
            expectedDamage = listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
            expectedControlDamage =
                listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
        ),
        PowerReferenceCase(
            name = "1682/ToughClaws/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
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
            expectedPower = 198,
            expectedDamage = listOf(37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44),
            expectedControlDamage =
                listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
        ),
        PowerReferenceCase(
            name = "1683/ToughClaws/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 5325,
            expectedPower = 79,
            expectedDamage = listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
            expectedControlDamage =
                listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
        ),
        PowerReferenceCase(
            name = "1684/ToughClaws/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
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
            expectedDamage = listOf(38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45),
            expectedControlDamage =
                listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
        ),
        PowerReferenceCase(
            name = "1685/ToughClaws/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1686/ToughClaws/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1687/ToughClaws/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1688/ToughClaws/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1689/ToughClaws/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1690/ToughClaws/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1691/ToughClaws/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1692/ToughClaws/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1693/ToughClaws/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 5325,
            expectedPower = 78,
            expectedDamage = listOf(30, 30, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36),
            expectedControlDamage =
                listOf(30, 30, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36),
        ),
        PowerReferenceCase(
            name = "1694/ToughClaws/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
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
            expectedMultiplier = 17552,
            expectedPower = 257,
            expectedDamage =
                listOf(
                    97,
                    98,
                    100,
                    101,
                    102,
                    103,
                    104,
                    105,
                    106,
                    108,
                    109,
                    110,
                    111,
                    112,
                    113,
                    115,
                ),
            expectedControlDamage =
                listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
        ),
        PowerReferenceCase(
            name = "1695/ToughClaws/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 5325,
            expectedPower = 79,
            expectedDamage = listOf(30, 30, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36),
            expectedControlDamage =
                listOf(30, 30, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36),
        ),
        PowerReferenceCase(
            name = "1696/ToughClaws/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
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
            expectedMultiplier = 17552,
            expectedPower = 261,
            expectedDamage =
                listOf(
                    98,
                    99,
                    100,
                    102,
                    103,
                    104,
                    105,
                    106,
                    107,
                    109,
                    110,
                    111,
                    112,
                    113,
                    114,
                    116,
                ),
            expectedControlDamage =
                listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
        ),
        PowerReferenceCase(
            name = "1697/ToughClaws/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 60, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1698/ToughClaws/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1699/ToughClaws/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 61, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1700/ToughClaws/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
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
        PowerReferenceCase(
            name = "1701/ToughClaws/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1702/ToughClaws/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1703/ToughClaws/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1704/ToughClaws/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("NormalGem"),
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

private fun powerReferenceToughClaws1CasesPart5(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1705/ToughClaws/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1706/ToughClaws/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1707/ToughClaws/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1708/ToughClaws/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1709/ToughClaws/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4915,
            expectedPower = 72,
            expectedDamage = listOf(14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16),
            expectedControlDamage =
                listOf(14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16),
        ),
        PowerReferenceCase(
            name = "1710/ToughClaws/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            expectedControlDamage =
                listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
        ),
        PowerReferenceCase(
            name = "1711/ToughClaws/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4915,
            expectedPower = 73,
            expectedDamage = listOf(14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 17),
            expectedControlDamage =
                listOf(14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 17),
        ),
        PowerReferenceCase(
            name = "1712/ToughClaws/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41),
            expectedControlDamage =
                listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
        ),
        PowerReferenceCase(
            name = "1713/ToughClaws/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1714/ToughClaws/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1715/ToughClaws/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
            expectedControlDamage =
                listOf(11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 14),
        ),
        PowerReferenceCase(
            name = "1716/ToughClaws/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1717/ToughClaws/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1718/ToughClaws/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1719/ToughClaws/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1720/ToughClaws/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
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
        PowerReferenceCase(
            name = "1721/ToughClaws/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 60, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4915,
            expectedPower = 72,
            expectedDamage = listOf(28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33),
            expectedControlDamage =
                listOf(28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33),
        ),
        PowerReferenceCase(
            name = "1722/ToughClaws/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
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
            expectedMultiplier = 16201,
            expectedPower = 237,
            expectedDamage =
                listOf(90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 106),
            expectedControlDamage =
                listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
        ),
        PowerReferenceCase(
            name = "1723/ToughClaws/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(MoveId("Tackle"), PokemonType.FIRE, 61, Category.SPECIAL, flags = EnumFlags()),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4915,
            expectedPower = 73,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
        ),
        PowerReferenceCase(
            name = "1724/ToughClaws/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
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
            expectedMultiplier = 16201,
            expectedPower = 241,
            expectedDamage =
                listOf(91, 92, 93, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 108),
            expectedControlDamage =
                listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
        ),
        PowerReferenceCase(
            name = "1725/ToughClaws/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 60,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
        PowerReferenceCase(
            name = "1726/ToughClaws/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
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
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1727/ToughClaws/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("ToughClaws"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags = EnumFlags(),
                ),
            effects = EnumFlags(),
            attackerStats = Stats(175, 120, 120, 120, 120, 120),
            defenderStats = Stats(175, 120, 120, 120, 120, 120),
            expectedMultiplier = 4096,
            expectedPower = 61,
            expectedDamage = listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
            expectedControlDamage =
                listOf(23, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28),
        ),
    )
