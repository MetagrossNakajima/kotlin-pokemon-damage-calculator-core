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
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats
import dev.pokemondamage.model.Weather

// Fixed reference expectations for DefenseHeatproof. See StatReferenceCases for provenance.
internal fun statReferenceDefenseHeatproofCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceDefenseHeatproofCasesPart1())
    }

private fun statReferenceDefenseHeatproofCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/101/",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 151,
            expectedDamage = listOf(2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/101/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 114,
            expectedDamage = listOf(3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/101/DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 151,
            expectedDamage = listOf(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name =
                "defense/Heatproof/Fire/Physical/101/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 114,
            expectedDamage = listOf(5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/333/",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 499,
            expectedDamage = listOf(2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/333/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 375,
            expectedDamage = listOf(3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/333/DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 499,
            expectedDamage = listOf(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name =
                "defense/Heatproof/Fire/Physical/333/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 375,
            expectedDamage = listOf(5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/999/",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1498,
            expectedDamage = listOf(2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/999/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1124,
            expectedDamage = listOf(3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Physical/999/DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1498,
            expectedDamage = listOf(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9),
        ),
        StatReferenceCase(
            name =
                "defense/Heatproof/Fire/Physical/999/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1124,
            expectedDamage = listOf(5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/101/",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 151,
            expectedDamage = listOf(5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/101/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 114,
            expectedDamage = listOf(7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 17),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/101/DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 227,
            expectedDamage = listOf(5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name =
                "defense/Heatproof/Fire/Special/101/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 50,
            expectedDefense = 170,
            expectedDamage = listOf(8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/333/",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 499,
            expectedDamage = listOf(5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/333/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 375,
            expectedDamage = listOf(7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 17),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/333/DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 749,
            expectedDamage = listOf(5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name =
                "defense/Heatproof/Fire/Special/333/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 166,
            expectedDefense = 562,
            expectedDamage = listOf(8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/999/",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1498,
            expectedDamage = listOf(5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/999/SWORD_OF_RUIN+BEADS_OF_RUIN",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.SWORD_OF_RUIN, FieldEffect.BEADS_OF_RUIN),
                ),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1124,
            expectedDamage = listOf(7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 17),
        ),
        StatReferenceCase(
            name = "defense/Heatproof/Fire/Special/999/DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.DEFENDER_FLOWER_GIFT),
                ),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 2248,
            expectedDamage = listOf(5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13),
        ),
        StatReferenceCase(
            name =
                "defense/Heatproof/Fire/Special/999/SWORD_OF_RUIN+BEADS_OF_RUIN+DEFENDER_FLOWER_GIFT",
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
                    ability = AbilityId("Heatproof"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
                    canEvolve = true,
                ),
            move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.FIRE,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = Weather.SUNLIGHT,
                    terrain = null,
                    effects =
                        EnumFlags(
                            FieldEffect.SWORD_OF_RUIN,
                            FieldEffect.BEADS_OF_RUIN,
                            FieldEffect.DEFENDER_FLOWER_GIFT,
                        ),
                ),
            critical = false,
            expectedAttack = 499,
            expectedDefense = 1686,
            expectedDamage = listOf(8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10),
            controlRole = StatControlRole.DEFENDER,
            expectedControlDamage =
                listOf(15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 18),
        ),
    )
