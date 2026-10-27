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

// Fixed reference expectations for PunkRock. See PowerReferenceCases for provenance.
internal fun powerReferencePunkRockCases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferencePunkRockCasesPart1())
        addAll(powerReferencePunkRockCasesPart2())
        addAll(powerReferencePunkRockCasesPart3())
        addAll(powerReferencePunkRockCasesPart4())
        addAll(powerReferencePunkRockCasesPart5())
    }

private fun powerReferencePunkRockCasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1729/PunkRock/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1730/PunkRock/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1731/PunkRock/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1732/PunkRock/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1733/PunkRock/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1734/PunkRock/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1735/PunkRock/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1736/PunkRock/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1737/PunkRock/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1738/PunkRock/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1739/PunkRock/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1740/PunkRock/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1741/PunkRock/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1742/PunkRock/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1743/PunkRock/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1744/PunkRock/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1745/PunkRock/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1746/PunkRock/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1747/PunkRock/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1748/PunkRock/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1749/PunkRock/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1750/PunkRock/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1751/PunkRock/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = null,
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1752/PunkRock/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1753/PunkRock/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1754/PunkRock/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1755/PunkRock/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1756/PunkRock/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1757/PunkRock/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1758/PunkRock/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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

private fun powerReferencePunkRockCasesPart2(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1759/PunkRock/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1760/PunkRock/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1761/PunkRock/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1762/PunkRock/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1763/PunkRock/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1764/PunkRock/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1765/PunkRock/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1766/PunkRock/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1767/PunkRock/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1768/PunkRock/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1769/PunkRock/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1770/PunkRock/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1771/PunkRock/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1772/PunkRock/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1773/PunkRock/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1774/PunkRock/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1775/PunkRock/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("MuscleBand"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1776/PunkRock/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1777/PunkRock/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1778/PunkRock/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1779/PunkRock/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1780/PunkRock/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1781/PunkRock/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1782/PunkRock/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1783/PunkRock/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1784/PunkRock/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1785/PunkRock/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1786/PunkRock/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1787/PunkRock/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1788/PunkRock/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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

private fun powerReferencePunkRockCasesPart3(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1789/PunkRock/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1790/PunkRock/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1791/PunkRock/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1792/PunkRock/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1793/PunkRock/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1794/PunkRock/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1795/PunkRock/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1796/PunkRock/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1797/PunkRock/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1798/PunkRock/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1799/PunkRock/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("WiseGlasses"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1800/PunkRock/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1801/PunkRock/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1802/PunkRock/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 11425,
            expectedPower = 167,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1803/PunkRock/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1804/PunkRock/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 11425,
            expectedPower = 170,
            expectedDamage = listOf(32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1805/PunkRock/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1806/PunkRock/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 11425,
            expectedPower = 167,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1807/PunkRock/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1808/PunkRock/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 11425,
            expectedPower = 170,
            expectedDamage = listOf(32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1809/PunkRock/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1810/PunkRock/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 11425,
            expectedPower = 167,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1811/PunkRock/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1812/PunkRock/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 11425,
            expectedPower = 170,
            expectedDamage = listOf(32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1813/PunkRock/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1814/PunkRock/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 14852,
            expectedPower = 218,
            expectedDamage = listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1815/PunkRock/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1816/PunkRock/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 14852,
            expectedPower = 221,
            expectedDamage = listOf(84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1817/PunkRock/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1818/PunkRock/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 14852,
            expectedPower = 218,
            expectedDamage = listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
    )

private fun powerReferencePunkRockCasesPart4(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1819/PunkRock/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1820/PunkRock/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 14852,
            expectedPower = 221,
            expectedDamage = listOf(84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1821/PunkRock/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1822/PunkRock/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 14852,
            expectedPower = 218,
            expectedDamage = listOf(82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1823/PunkRock/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("PunchingGlove"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1824/PunkRock/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            expectedMultiplier = 14852,
            expectedPower = 221,
            expectedDamage = listOf(84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1825/PunkRock/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1826/PunkRock/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1827/PunkRock/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1828/PunkRock/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1829/PunkRock/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1830/PunkRock/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1831/PunkRock/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1832/PunkRock/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1833/PunkRock/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1834/PunkRock/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1835/PunkRock/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1836/PunkRock/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1837/PunkRock/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1838/PunkRock/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1839/PunkRock/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1840/PunkRock/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1841/PunkRock/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1842/PunkRock/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1843/PunkRock/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1844/PunkRock/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1845/PunkRock/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1846/PunkRock/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1847/PunkRock/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("NormalGem"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1848/PunkRock/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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

private fun powerReferencePunkRockCasesPart5(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1849/PunkRock/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1850/PunkRock/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1851/PunkRock/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1852/PunkRock/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1853/PunkRock/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1854/PunkRock/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1855/PunkRock/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1856/PunkRock/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1857/PunkRock/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1858/PunkRock/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1859/PunkRock/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.PHYSICAL,
                    flags =
                        EnumFlags(),
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
            name = "1860/PunkRock/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1861/PunkRock/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1862/PunkRock/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1863/PunkRock/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1864/PunkRock/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1865/PunkRock/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1866/PunkRock/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1867/PunkRock/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1868/PunkRock/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("PunkRock"),
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
            name = "1869/PunkRock/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    60,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1870/PunkRock/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("PunkRock"),
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
            name = "1871/PunkRock/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
            item = ItemId("Charcoal"),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.STEEL,
                    61,
                    Category.SPECIAL,
                    flags =
                        EnumFlags(),
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
            name = "1872/PunkRock/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("PunkRock"),
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
