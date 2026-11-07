package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.Stat
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Terrain
import dev.pokemondamage.model.Weather

// Fixed reference expectations for AttackQuarkDrive. See StatReferenceCases for provenance.
internal fun statReferenceAttackQuarkDriveCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceAttackQuarkDriveCasesPart1())
    }

private fun statReferenceAttackQuarkDriveCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/101/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = Terrain.ELECTRIC, effects = EnumFlags()),
            critical = false,
            expectedAttack = 197,
            expectedDefense = 101,
            expectedDamage = listOf(22, 22, 23, 23, 24, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 27),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = Terrain.ELECTRIC,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 148,
            expectedDefense = 101,
            expectedDamage = listOf(16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 20),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(12, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/101/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 295,
            expectedDefense = 101,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 36, 36, 36, 36, 37, 37, 38, 38, 39, 39),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30, 30, 30),
        ),
        StatReferenceCase(
            name =
                "attack/Quark Drive/Physical/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 222,
            expectedDefense = 101,
            expectedDamage = listOf(25, 25, 25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(19, 19, 19, 20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 23),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/333/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = Terrain.ELECTRIC, effects = EnumFlags()),
            critical = false,
            expectedAttack = 649,
            expectedDefense = 333,
            expectedDamage = listOf(22, 22, 23, 23, 24, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 27),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = Terrain.ELECTRIC,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 487,
            expectedDefense = 333,
            expectedDamage = listOf(16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 20),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(12, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/333/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 974,
            expectedDefense = 333,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 36, 36, 36, 36, 37, 37, 38, 38, 39, 39),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30, 30, 30),
        ),
        StatReferenceCase(
            name =
                "attack/Quark Drive/Physical/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 731,
            expectedDefense = 333,
            expectedDamage = listOf(25, 25, 25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(19, 19, 19, 20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 23),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/999/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = Terrain.ELECTRIC, effects = EnumFlags()),
            critical = false,
            expectedAttack = 1948,
            expectedDefense = 999,
            expectedDamage = listOf(22, 22, 23, 23, 24, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 27),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(17, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = Terrain.ELECTRIC,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 1461,
            expectedDefense = 999,
            expectedDamage = listOf(16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 20),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(12, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Physical/999/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 2922,
            expectedDefense = 999,
            expectedDamage = listOf(33, 33, 34, 34, 35, 35, 36, 36, 36, 36, 37, 37, 38, 38, 39, 39),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30, 30, 30),
        ),
        StatReferenceCase(
            name =
                "attack/Quark Drive/Physical/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceBand"),
                    boostedStat = Stat.ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 2192,
            expectedDefense = 999,
            expectedDamage = listOf(25, 25, 25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(19, 19, 19, 20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 23),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/101/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = Terrain.ELECTRIC, effects = EnumFlags()),
            critical = false,
            expectedAttack = 197,
            expectedDefense = 101,
            expectedDamage = listOf(45, 45, 46, 46, 48, 48, 48, 49, 49, 49, 51, 51, 51, 52, 52, 54),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = Terrain.ELECTRIC,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 148,
            expectedDefense = 101,
            expectedDamage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 31),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/101/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 197,
            expectedDefense = 101,
            expectedDamage = listOf(45, 45, 46, 46, 48, 48, 48, 49, 49, 49, 51, 51, 51, 52, 52, 54),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        StatReferenceCase(
            name =
                "attack/Quark Drive/Special/101/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 148,
            expectedDefense = 101,
            expectedDamage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 31),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/333/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = Terrain.ELECTRIC, effects = EnumFlags()),
            critical = false,
            expectedAttack = 649,
            expectedDefense = 333,
            expectedDamage = listOf(45, 45, 46, 46, 48, 48, 48, 49, 49, 49, 51, 51, 51, 52, 52, 54),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = Terrain.ELECTRIC,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 487,
            expectedDefense = 333,
            expectedDamage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 31),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/333/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 649,
            expectedDefense = 333,
            expectedDamage = listOf(45, 45, 46, 46, 48, 48, 48, 49, 49, 49, 51, 51, 51, 52, 52, 54),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        StatReferenceCase(
            name =
                "attack/Quark Drive/Special/333/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 487,
            expectedDefense = 333,
            expectedDamage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 31),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/999/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = Terrain.ELECTRIC, effects = EnumFlags()),
            critical = false,
            expectedAttack = 1948,
            expectedDefense = 999,
            expectedDamage = listOf(45, 45, 46, 46, 48, 48, 48, 49, 49, 49, 51, 51, 51, 52, 52, 54),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = Terrain.ELECTRIC,
                    effects = EnumFlags(FieldEffect.TABLETS_OF_RUIN, FieldEffect.VESSEL_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 1461,
            expectedDefense = 999,
            expectedDamage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 31),
        ),
        StatReferenceCase(
            name = "attack/Quark Drive/Special/999/ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(FieldEffect.ATTACKER_FLOWER_GIFT, FieldEffect.STEELY_SPIRIT),
                ),
            critical = false,
            expectedAttack = 1948,
            expectedDefense = 999,
            expectedDamage = listOf(45, 45, 46, 46, 48, 48, 48, 49, 49, 49, 51, 51, 51, 52, 52, 54),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(34, 36, 36, 36, 36, 37, 37, 37, 39, 39, 39, 39, 40, 40, 40, 42),
        ),
        StatReferenceCase(
            name =
                "attack/Quark Drive/Special/999/TABLETS_OF_RUIN+VESSEL_OF_RUIN+ATTACKER_FLOWER_GIFT+STEELY_SPIRIT",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("ChoiceSpecs"),
                    boostedStat = Stat.SPECIAL_ATTACK,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = Terrain.ELECTRIC,
                    effects =
                        EnumFlags(
                            FieldEffect.TABLETS_OF_RUIN,
                            FieldEffect.VESSEL_OF_RUIN,
                            FieldEffect.ATTACKER_FLOWER_GIFT,
                            FieldEffect.STEELY_SPIRIT,
                        ),
                ),
            critical = false,
            expectedAttack = 1461,
            expectedDefense = 999,
            expectedDamage = listOf(33, 34, 34, 34, 36, 36, 36, 36, 37, 37, 37, 37, 39, 39, 39, 40),
            controlRole = StatControlRole.ATTACKER,
            expectedControlDamage =
                listOf(25, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 31),
        ),
    )
