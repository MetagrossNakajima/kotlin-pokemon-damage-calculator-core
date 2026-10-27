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

// Fixed reference expectations for Reckless. See PowerReferenceCases for provenance.
internal fun powerReferenceRecklessCases(): List<PowerReferenceCase> =
    buildList {
        addAll(powerReferenceRecklessCasesPart1())
        addAll(powerReferenceRecklessCasesPart2())
        addAll(powerReferenceRecklessCasesPart3())
        addAll(powerReferenceRecklessCasesPart4())
        addAll(powerReferenceRecklessCasesPart5())
    }

private fun powerReferenceRecklessCasesPart1(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "2017/Reckless/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2018/Reckless/no-item/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2019/Reckless/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2020/Reckless/no-item/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2021/Reckless/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2022/Reckless/no-item/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2023/Reckless/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2024/Reckless/no-item/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2025/Reckless/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2026/Reckless/no-item/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2027/Reckless/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2028/Reckless/no-item/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2029/Reckless/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2030/Reckless/no-item/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2031/Reckless/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2032/Reckless/no-item/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2033/Reckless/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2034/Reckless/no-item/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2035/Reckless/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2036/Reckless/no-item/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2037/Reckless/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2038/Reckless/no-item/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2039/Reckless/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2040/Reckless/no-item/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2041/Reckless/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2042/Reckless/MuscleBand/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10542,
            expectedPower = 154,
            expectedDamage = listOf(29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "2043/Reckless/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2044/Reckless/MuscleBand/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10542,
            expectedPower = 157,
            expectedDamage = listOf(30, 30, 30, 31, 31, 31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "2045/Reckless/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2046/Reckless/MuscleBand/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10542,
            expectedPower = 154,
            expectedDamage = listOf(29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
    )

private fun powerReferenceRecklessCasesPart2(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "2047/Reckless/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2048/Reckless/MuscleBand/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10542,
            expectedPower = 157,
            expectedDamage = listOf(30, 30, 30, 31, 31, 31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "2049/Reckless/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2050/Reckless/MuscleBand/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10542,
            expectedPower = 154,
            expectedDamage = listOf(29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "2051/Reckless/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2052/Reckless/MuscleBand/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10542,
            expectedPower = 157,
            expectedDamage = listOf(30, 30, 30, 31, 31, 31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "2053/Reckless/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2054/Reckless/MuscleBand/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2055/Reckless/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2056/Reckless/MuscleBand/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2057/Reckless/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2058/Reckless/MuscleBand/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2059/Reckless/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2060/Reckless/MuscleBand/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2061/Reckless/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2062/Reckless/MuscleBand/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2063/Reckless/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2064/Reckless/MuscleBand/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2065/Reckless/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2066/Reckless/WiseGlasses/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2067/Reckless/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2068/Reckless/WiseGlasses/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2069/Reckless/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2070/Reckless/WiseGlasses/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2071/Reckless/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2072/Reckless/WiseGlasses/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2073/Reckless/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2074/Reckless/WiseGlasses/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2075/Reckless/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2076/Reckless/WiseGlasses/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
    )

private fun powerReferenceRecklessCasesPart3(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "2077/Reckless/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2078/Reckless/WiseGlasses/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13705,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "2079/Reckless/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2080/Reckless/WiseGlasses/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13705,
            expectedPower = 204,
            expectedDamage = listOf(77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "2081/Reckless/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2082/Reckless/WiseGlasses/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13705,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "2083/Reckless/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2084/Reckless/WiseGlasses/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13705,
            expectedPower = 204,
            expectedDamage = listOf(77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "2085/Reckless/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2086/Reckless/WiseGlasses/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13705,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "2087/Reckless/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2088/Reckless/WiseGlasses/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13705,
            expectedPower = 204,
            expectedDamage = listOf(77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "2089/Reckless/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2090/Reckless/PunchingGlove/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10544,
            expectedPower = 154,
            expectedDamage = listOf(29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "2091/Reckless/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2092/Reckless/PunchingGlove/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10544,
            expectedPower = 157,
            expectedDamage = listOf(30, 30, 30, 31, 31, 31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "2093/Reckless/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2094/Reckless/PunchingGlove/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10544,
            expectedPower = 154,
            expectedDamage = listOf(29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "2095/Reckless/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2096/Reckless/PunchingGlove/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10544,
            expectedPower = 157,
            expectedDamage = listOf(30, 30, 30, 31, 31, 31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "2097/Reckless/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2098/Reckless/PunchingGlove/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10544,
            expectedPower = 154,
            expectedDamage = listOf(29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34),
            expectedControlDamage =
                listOf(24, 24, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 28, 28, 28, 29),
        ),
        PowerReferenceCase(
            name = "2099/Reckless/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2100/Reckless/PunchingGlove/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 10544,
            expectedPower = 157,
            expectedDamage = listOf(30, 30, 30, 31, 31, 31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35),
            expectedControlDamage =
                listOf(25, 25, 25, 25, 26, 26, 26, 27, 27, 27, 28, 28, 28, 28, 29, 29),
        ),
        PowerReferenceCase(
            name = "2101/Reckless/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2102/Reckless/PunchingGlove/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13708,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "2103/Reckless/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2104/Reckless/PunchingGlove/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13708,
            expectedPower = 204,
            expectedDamage = listOf(77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "2105/Reckless/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2106/Reckless/PunchingGlove/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13708,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
    )

private fun powerReferenceRecklessCasesPart4(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "2107/Reckless/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2108/Reckless/PunchingGlove/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13708,
            expectedPower = 204,
            expectedDamage = listOf(77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "2109/Reckless/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2110/Reckless/PunchingGlove/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13708,
            expectedPower = 201,
            expectedDamage = listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
            expectedControlDamage =
                listOf(63, 64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75),
        ),
        PowerReferenceCase(
            name = "2111/Reckless/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2112/Reckless/PunchingGlove/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 13708,
            expectedPower = 204,
            expectedDamage = listOf(77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91),
            expectedControlDamage =
                listOf(64, 65, 66, 66, 67, 68, 69, 69, 70, 71, 72, 72, 73, 74, 75, 76),
        ),
        PowerReferenceCase(
            name = "2113/Reckless/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2114/Reckless/NormalGem/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 38, 39, 39, 40, 40, 41),
            expectedControlDamage =
                listOf(28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 34),
        ),
        PowerReferenceCase(
            name = "2115/Reckless/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2116/Reckless/NormalGem/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 39, 40, 40, 41, 41),
            expectedControlDamage =
                listOf(29, 30, 30, 30, 31, 31, 31, 32, 32, 32, 33, 33, 33, 34, 34, 35),
        ),
        PowerReferenceCase(
            name = "2117/Reckless/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2118/Reckless/NormalGem/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2119/Reckless/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2120/Reckless/NormalGem/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2121/Reckless/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2122/Reckless/NormalGem/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2123/Reckless/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2124/Reckless/NormalGem/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2125/Reckless/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2126/Reckless/NormalGem/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 16200,
            expectedPower = 237,
            expectedDamage =
                listOf(90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 106),
            expectedControlDamage =
                listOf(75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89),
        ),
        PowerReferenceCase(
            name = "2127/Reckless/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2128/Reckless/NormalGem/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 16200,
            expectedPower = 241,
            expectedDamage =
                listOf(91, 92, 93, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 108),
            expectedControlDamage =
                listOf(76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90),
        ),
        PowerReferenceCase(
            name = "2129/Reckless/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2130/Reckless/NormalGem/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2131/Reckless/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2132/Reckless/NormalGem/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2133/Reckless/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2134/Reckless/NormalGem/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2135/Reckless/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2136/Reckless/NormalGem/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )

private fun powerReferenceRecklessCasesPart5(): List<PowerReferenceCase> =
    listOf(
        PowerReferenceCase(
            name = "2137/Reckless/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2138/Reckless/Charcoal/PHYSICAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2139/Reckless/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2140/Reckless/Charcoal/PHYSICAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2141/Reckless/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2142/Reckless/Charcoal/PHYSICAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 11502,
            expectedPower = 168,
            expectedDamage = listOf(31, 32, 32, 33, 33, 33, 34, 34, 34, 35, 35, 36, 36, 36, 37, 37),
            expectedControlDamage =
                listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
        ),
        PowerReferenceCase(
            name = "2143/Reckless/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2144/Reckless/Charcoal/PHYSICAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 11502,
            expectedPower = 171,
            expectedDamage = listOf(32, 33, 33, 33, 34, 34, 35, 35, 35, 36, 36, 36, 37, 37, 38, 38),
            expectedControlDamage =
                listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
        ),
        PowerReferenceCase(
            name = "2145/Reckless/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2146/Reckless/Charcoal/PHYSICAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 140,
            expectedDamage = listOf(26, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31),
            expectedControlDamage =
                listOf(22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26),
        ),
        PowerReferenceCase(
            name = "2147/Reckless/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2148/Reckless/Charcoal/PHYSICAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 9585,
            expectedPower = 143,
            expectedDamage = listOf(27, 27, 27, 28, 28, 28, 29, 29, 29, 30, 30, 30, 31, 31, 31, 32),
            expectedControlDamage =
                listOf(22, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 27),
        ),
        PowerReferenceCase(
            name = "2149/Reckless/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2150/Reckless/Charcoal/SPECIAL/NORMAL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2151/Reckless/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2152/Reckless/Charcoal/SPECIAL/NORMAL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
        PowerReferenceCase(
            name = "2153/Reckless/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2154/Reckless/Charcoal/SPECIAL/FIRE/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 14953,
            expectedPower = 219,
            expectedDamage = listOf(83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98),
            expectedControlDamage =
                listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
        ),
        PowerReferenceCase(
            name = "2155/Reckless/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2156/Reckless/Charcoal/SPECIAL/FIRE/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 14953,
            expectedPower = 223,
            expectedDamage =
                listOf(85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100),
            expectedControlDamage =
                listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
        ),
        PowerReferenceCase(
            name = "2157/Reckless/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            name = "2158/Reckless/Charcoal/SPECIAL/STEEL/power=60",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 183,
            expectedDamage = listOf(69, 70, 71, 72, 72, 73, 74, 75, 76, 77, 77, 78, 79, 80, 81, 82),
            expectedControlDamage =
                listOf(57, 58, 59, 59, 60, 61, 61, 62, 63, 63, 64, 65, 65, 66, 67, 68),
        ),
        PowerReferenceCase(
            name = "2159/Reckless/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            name = "2160/Reckless/Charcoal/SPECIAL/STEEL/power=61",
            ability = AbilityId("Reckless"),
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
            expectedMultiplier = 12461,
            expectedPower = 186,
            expectedDamage = listOf(70, 71, 72, 73, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83),
            expectedControlDamage =
                listOf(59, 60, 60, 61, 62, 63, 63, 64, 65, 65, 66, 67, 67, 68, 69, 70),
        ),
    )
