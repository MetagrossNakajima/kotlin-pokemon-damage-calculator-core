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

// Fixed reference expectations for Illuminate. See PowerReferenceCases for provenance.
internal fun powerReferenceIlluminateCases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceIlluminateCasesPart1())
        addAll(powerReferenceIlluminateCasesPart2())
        addAll(powerReferenceIlluminateCasesPart3())
        addAll(powerReferenceIlluminateCasesPart4())
        addAll(powerReferenceIlluminateCasesPart5())
    }

private fun powerReferenceIlluminateCasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1/Illuminate/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "2/Illuminate/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "3/Illuminate/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "4/Illuminate/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "5/Illuminate/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "6/Illuminate/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "7/Illuminate/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "8/Illuminate/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "9/Illuminate/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "10/Illuminate/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "11/Illuminate/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "12/Illuminate/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "13/Illuminate/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "14/Illuminate/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "15/Illuminate/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "16/Illuminate/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "17/Illuminate/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "18/Illuminate/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "19/Illuminate/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "20/Illuminate/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "21/Illuminate/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "22/Illuminate/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "23/Illuminate/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "24/Illuminate/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "25/Illuminate/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "26/Illuminate/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 8786,
            expectedPower = 129,
            expectedDamage = listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "27/Illuminate/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "28/Illuminate/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 8786,
            expectedPower = 131,
            expectedDamage = listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "29/Illuminate/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "30/Illuminate/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 8786,
            expectedPower = 129,
            expectedDamage = listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
    )

private fun powerReferenceIlluminateCasesPart2(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "31/Illuminate/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "32/Illuminate/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 8786,
            expectedPower = 131,
            expectedDamage = listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "33/Illuminate/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "34/Illuminate/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 8786,
            expectedPower = 129,
            expectedDamage = listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "35/Illuminate/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "36/Illuminate/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 8786,
            expectedPower = 131,
            expectedDamage = listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "37/Illuminate/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "38/Illuminate/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "39/Illuminate/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "40/Illuminate/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "41/Illuminate/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "42/Illuminate/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "43/Illuminate/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "44/Illuminate/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "45/Illuminate/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "46/Illuminate/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "47/Illuminate/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "48/Illuminate/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "49/Illuminate/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "50/Illuminate/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "51/Illuminate/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "52/Illuminate/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "53/Illuminate/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "54/Illuminate/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "55/Illuminate/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "56/Illuminate/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "57/Illuminate/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "58/Illuminate/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "59/Illuminate/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "60/Illuminate/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
    )

private fun powerReferenceIlluminateCasesPart3(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "61/Illuminate/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "62/Illuminate/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 11422,
            expectedPower = 167,
            expectedDamage = listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "63/Illuminate/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "64/Illuminate/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 11422,
            expectedPower = 170,
            expectedDamage = listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "65/Illuminate/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "66/Illuminate/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 11422,
            expectedPower = 167,
            expectedDamage = listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "67/Illuminate/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "68/Illuminate/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 11422,
            expectedPower = 170,
            expectedDamage = listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "69/Illuminate/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "70/Illuminate/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 11422,
            expectedPower = 167,
            expectedDamage = listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "71/Illuminate/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "72/Illuminate/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 11422,
            expectedPower = 170,
            expectedDamage = listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "73/Illuminate/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "74/Illuminate/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "75/Illuminate/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "76/Illuminate/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "77/Illuminate/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "78/Illuminate/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "79/Illuminate/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "80/Illuminate/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "81/Illuminate/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "82/Illuminate/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "83/Illuminate/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "84/Illuminate/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "85/Illuminate/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "86/Illuminate/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "87/Illuminate/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "88/Illuminate/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "89/Illuminate/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "90/Illuminate/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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

private fun powerReferenceIlluminateCasesPart4(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "91/Illuminate/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "92/Illuminate/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "93/Illuminate/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "94/Illuminate/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "95/Illuminate/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "96/Illuminate/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "97/Illuminate/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "98/Illuminate/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
            expectedControlDamage =
                listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
        ),
        PowerReferenceCase(
            name = "99/Illuminate/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "100/Illuminate/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
            expectedControlDamage =
                listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
        ),
        PowerReferenceCase(
            name = "101/Illuminate/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "102/Illuminate/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "103/Illuminate/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "104/Illuminate/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "105/Illuminate/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "106/Illuminate/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "107/Illuminate/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "108/Illuminate/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "109/Illuminate/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "110/Illuminate/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 13501,
            expectedPower = 198,
            expectedDamage = listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
            expectedControlDamage =
                listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
        ),
        PowerReferenceCase(
            name = "111/Illuminate/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "112/Illuminate/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 13501,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
        ),
        PowerReferenceCase(
            name = "113/Illuminate/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "114/Illuminate/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "115/Illuminate/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "116/Illuminate/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "117/Illuminate/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "118/Illuminate/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "119/Illuminate/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "120/Illuminate/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )

private fun powerReferenceIlluminateCasesPart5(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "121/Illuminate/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "122/Illuminate/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "123/Illuminate/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "124/Illuminate/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "125/Illuminate/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "126/Illuminate/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
        ),
        PowerReferenceCase(
            name = "127/Illuminate/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "128/Illuminate/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
        ),
        PowerReferenceCase(
            name = "129/Illuminate/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "130/Illuminate/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 117,
            expectedDamage = listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "131/Illuminate/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "132/Illuminate/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 7988,
            expectedPower = 119,
            expectedDamage = listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "133/Illuminate/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "134/Illuminate/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "135/Illuminate/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "136/Illuminate/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "137/Illuminate/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "138/Illuminate/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
        ),
        PowerReferenceCase(
            name = "139/Illuminate/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "140/Illuminate/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
        ),
        PowerReferenceCase(
            name = "141/Illuminate/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            name = "142/Illuminate/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 152,
            expectedDamage = listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "143/Illuminate/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            name = "144/Illuminate/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("Illuminate"),
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
            expectedMultiplier = 10385,
            expectedPower = 155,
            expectedDamage = listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )
