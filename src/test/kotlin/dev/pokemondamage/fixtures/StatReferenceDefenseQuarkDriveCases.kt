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

// Fixed reference expectations for DefenseQuarkDrive. See StatReferenceCases for provenance.
internal fun statReferenceDefenseQuarkDriveCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceDefenseQuarkDriveCasesPart1())
    }

private fun statReferenceDefenseQuarkDriveCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/101/",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
            expectedAttack = 101,
            expectedDefense = 197,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/101/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 148,
            expectedDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/101/DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 197,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name =
                "defense/Quark Drive/Normal/Physical/101/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 148,
            expectedDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/333/",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
            expectedAttack = 333,
            expectedDefense = 649,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/333/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 487,
            expectedDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/333/DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 649,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name =
                "defense/Quark Drive/Normal/Physical/333/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 487,
            expectedDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/999/",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
            expectedAttack = 999,
            expectedDefense = 1948,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/999/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1461,
            expectedDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Physical/999/DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1948,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name =
                "defense/Quark Drive/Normal/Physical/999/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.DEFENSE,
                    canEvolve = true,
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
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1461,
            expectedDamage = listOf(8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/101/",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
            expectedAttack = 101,
            expectedDefense = 197,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/101/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 148,
            expectedDamage = listOf(16, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 21),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/101/DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 295,
            expectedDamage = listOf(9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name =
                "defense/Quark Drive/Normal/Special/101/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 222,
            expectedDamage = listOf(12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 15),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 18),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/333/",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
            expectedAttack = 333,
            expectedDefense = 649,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/333/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 487,
            expectedDamage = listOf(16, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 21),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/333/DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 974,
            expectedDamage = listOf(9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name =
                "defense/Quark Drive/Normal/Special/333/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 333, 333, 333, 333, 333),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 333,
            expectedDefense = 730,
            expectedDamage = listOf(12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 15),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 18),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/999/",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
            expectedAttack = 999,
            expectedDefense = 1948,
            expectedDamage = listOf(13, 13, 13, 13, 13, 13, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/999/SWORD_OF_RUIN+BEADS_OF_RUIN",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 1461,
            expectedDamage = listOf(16, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 21),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 25),
        ),
        StatReferenceCase(
            name = "defense/Quark Drive/Normal/Special/999/DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 2922,
            expectedDamage = listOf(9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name =
                "defense/Quark Drive/Normal/Special/999/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
            attacker =
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
            defender =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 999, 999, 999, 999, 999),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("QuarkDrive"),
                    item = ItemId("Eviolite"),
                    boostedStat = Stat.SPECIAL_DEFENSE,
                    canEvolve = true,
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
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 999,
            expectedDefense = 2191,
            expectedDamage = listOf(12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 15),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 18),
        ),
    )
