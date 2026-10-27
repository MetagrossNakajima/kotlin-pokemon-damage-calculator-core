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

// Fixed reference expectations for Sharpness. See PowerReferenceCases for provenance.
internal fun powerReferenceSharpnessCases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceSharpnessCasesPart1())
        addAll(powerReferenceSharpnessCasesPart2())
        addAll(powerReferenceSharpnessCasesPart3())
        addAll(powerReferenceSharpnessCasesPart4())
        addAll(powerReferenceSharpnessCasesPart5())
    }

private fun powerReferenceSharpnessCasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1009/Sharpness/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1010/Sharpness/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1011/Sharpness/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1012/Sharpness/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1013/Sharpness/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1014/Sharpness/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1015/Sharpness/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1016/Sharpness/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1017/Sharpness/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1018/Sharpness/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1019/Sharpness/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1020/Sharpness/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1021/Sharpness/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1022/Sharpness/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1023/Sharpness/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1024/Sharpness/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1025/Sharpness/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1026/Sharpness/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1027/Sharpness/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1028/Sharpness/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1029/Sharpness/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1030/Sharpness/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1031/Sharpness/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1032/Sharpness/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1033/Sharpness/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1034/Sharpness/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13177,
            expectedPower = 193,
            expectedDamage = listOf(36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1035/Sharpness/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1036/Sharpness/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13177,
            expectedPower = 196,
            expectedDamage = listOf(37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1037/Sharpness/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1038/Sharpness/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13177,
            expectedPower = 193,
            expectedDamage = listOf(36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
    )

private fun powerReferenceSharpnessCasesPart2(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1039/Sharpness/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1040/Sharpness/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13177,
            expectedPower = 196,
            expectedDamage = listOf(37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1041/Sharpness/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1042/Sharpness/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13177,
            expectedPower = 193,
            expectedDamage = listOf(36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1043/Sharpness/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1044/Sharpness/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13177,
            expectedPower = 196,
            expectedDamage = listOf(37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1045/Sharpness/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1046/Sharpness/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1047/Sharpness/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1048/Sharpness/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1049/Sharpness/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1050/Sharpness/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1051/Sharpness/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1052/Sharpness/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1053/Sharpness/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1054/Sharpness/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1055/Sharpness/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1056/Sharpness/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1057/Sharpness/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1058/Sharpness/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1059/Sharpness/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1060/Sharpness/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1061/Sharpness/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1062/Sharpness/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1063/Sharpness/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1064/Sharpness/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1065/Sharpness/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1066/Sharpness/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1067/Sharpness/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1068/Sharpness/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
    )

private fun powerReferenceSharpnessCasesPart3(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1069/Sharpness/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1070/Sharpness/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17131,
            expectedPower = 251,
            expectedDamage =
                listOf(95, 96, 97, 98, 99, 100, 101, 103, 104, 105, 106, 107, 108, 109, 110, 112),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1071/Sharpness/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1072/Sharpness/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17131,
            expectedPower = 255,
            expectedDamage =
                listOf(96, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 114),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1073/Sharpness/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1074/Sharpness/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17131,
            expectedPower = 251,
            expectedDamage =
                listOf(95, 96, 97, 98, 99, 100, 101, 103, 104, 105, 106, 107, 108, 109, 110, 112),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1075/Sharpness/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1076/Sharpness/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17131,
            expectedPower = 255,
            expectedDamage =
                listOf(96, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 114),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1077/Sharpness/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1078/Sharpness/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17131,
            expectedPower = 251,
            expectedDamage =
                listOf(95, 96, 97, 98, 99, 100, 101, 103, 104, 105, 106, 107, 108, 109, 110, 112),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1079/Sharpness/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1080/Sharpness/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17131,
            expectedPower = 255,
            expectedDamage =
                listOf(96, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 114),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1081/Sharpness/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1082/Sharpness/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13180,
            expectedPower = 193,
            expectedDamage = listOf(36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1083/Sharpness/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1084/Sharpness/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13180,
            expectedPower = 196,
            expectedDamage = listOf(37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1085/Sharpness/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1086/Sharpness/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13180,
            expectedPower = 193,
            expectedDamage = listOf(36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1087/Sharpness/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1088/Sharpness/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13180,
            expectedPower = 196,
            expectedDamage = listOf(37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1089/Sharpness/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1090/Sharpness/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13180,
            expectedPower = 193,
            expectedDamage = listOf(36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41, 42, 42, 43),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "1091/Sharpness/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1092/Sharpness/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 13180,
            expectedPower = 196,
            expectedDamage = listOf(37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 44),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "1093/Sharpness/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1094/Sharpness/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17135,
            expectedPower = 251,
            expectedDamage =
                listOf(95, 96, 97, 98, 99, 100, 101, 103, 104, 105, 106, 107, 108, 109, 110, 112),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1095/Sharpness/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1096/Sharpness/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17135,
            expectedPower = 255,
            expectedDamage =
                listOf(96, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 114),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1097/Sharpness/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1098/Sharpness/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17135,
            expectedPower = 251,
            expectedDamage =
                listOf(95, 96, 97, 98, 99, 100, 101, 103, 104, 105, 106, 107, 108, 109, 110, 112),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
    )

private fun powerReferenceSharpnessCasesPart4(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1099/Sharpness/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1100/Sharpness/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17135,
            expectedPower = 255,
            expectedDamage =
                listOf(96, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 114),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1101/Sharpness/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1102/Sharpness/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17135,
            expectedPower = 251,
            expectedDamage =
                listOf(95, 96, 97, 98, 99, 100, 101, 103, 104, 105, 106, 107, 108, 109, 110, 112),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "1103/Sharpness/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1104/Sharpness/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 17135,
            expectedPower = 255,
            expectedDamage =
                listOf(96, 98, 99, 100, 101, 102, 103, 104, 106, 107, 108, 109, 110, 111, 112, 114),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "1105/Sharpness/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1106/Sharpness/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage = listOf(43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 51),
            expectedControlDamage =
                listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
        ),
        PowerReferenceCase(
            name = "1107/Sharpness/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1108/Sharpness/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage = listOf(44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 52),
            expectedControlDamage =
                listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
        ),
        PowerReferenceCase(
            name = "1109/Sharpness/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1110/Sharpness/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1111/Sharpness/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1112/Sharpness/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1113/Sharpness/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1114/Sharpness/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1115/Sharpness/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1116/Sharpness/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1117/Sharpness/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1118/Sharpness/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 20250,
            expectedPower = 297,
            expectedDamage =
                listOf(
                    112,
                    113,
                    114,
                    116,
                    117,
                    118,
                    120,
                    121,
                    122,
                    124,
                    125,
                    126,
                    128,
                    129,
                    130,
                    132,
                ),
            expectedControlDamage =
                listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
        ),
        PowerReferenceCase(
            name = "1119/Sharpness/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1120/Sharpness/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 20250,
            expectedPower = 302,
            expectedDamage =
                listOf(
                    113,
                    115,
                    116,
                    117,
                    119,
                    120,
                    121,
                    123,
                    124,
                    125,
                    127,
                    128,
                    129,
                    131,
                    132,
                    134,
                ),
            expectedControlDamage =
                listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
        ),
        PowerReferenceCase(
            name = "1121/Sharpness/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1122/Sharpness/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1123/Sharpness/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1124/Sharpness/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1125/Sharpness/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1126/Sharpness/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1127/Sharpness/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1128/Sharpness/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )

private fun powerReferenceSharpnessCasesPart5(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "1129/Sharpness/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1130/Sharpness/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1131/Sharpness/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1132/Sharpness/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1133/Sharpness/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1134/Sharpness/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 14377,
            expectedPower = 211,
            expectedDamage = listOf(39, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47),
            expectedControlDamage =
                listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
        ),
        PowerReferenceCase(
            name = "1135/Sharpness/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1136/Sharpness/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 14377,
            expectedPower = 214,
            expectedDamage = listOf(40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48),
            expectedControlDamage =
                listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
        ),
        PowerReferenceCase(
            name = "1137/Sharpness/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1138/Sharpness/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 176,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "1139/Sharpness/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1140/Sharpness/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 11981,
            expectedPower = 178,
            expectedDamage = listOf(34, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "1141/Sharpness/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1142/Sharpness/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1143/Sharpness/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1144/Sharpness/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 232,
            expectedDamage =
                listOf(88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 104),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "1145/Sharpness/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1146/Sharpness/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 18690,
            expectedPower = 274,
            expectedDamage =
                listOf(
                    103,
                    104,
                    106,
                    107,
                    108,
                    109,
                    111,
                    112,
                    113,
                    114,
                    115,
                    117,
                    118,
                    119,
                    120,
                    122,
                ),
            expectedControlDamage =
                listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
        ),
        PowerReferenceCase(
            name = "1147/Sharpness/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1148/Sharpness/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 18690,
            expectedPower = 278,
            expectedDamage =
                listOf(
                    105,
                    106,
                    107,
                    109,
                    110,
                    111,
                    112,
                    114,
                    115,
                    116,
                    117,
                    119,
                    120,
                    121,
                    122,
                    124,
                ),
            expectedControlDamage =
                listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
        ),
        PowerReferenceCase(
            name = "1149/Sharpness/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            name = "1150/Sharpness/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("Sharpness"),
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
            expectedMultiplier = 15576,
            expectedPower = 228,
            expectedDamage =
                listOf(86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 102),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "1151/Sharpness/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
            name = "1152/Sharpness/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("Sharpness"),
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
