package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.FieldEffect
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats

// Fixed reference expectations for RanksChipAway. See StatReferenceCases for provenance.
internal fun statReferenceRanksChipAwayCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceRanksChipAwayCasesPart1())
    }

private fun statReferenceRanksChipAwayCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "ranks/Chip Away/-6/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 25,
            expectedDefense = 101,
            expectedDamage = listOf(5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-6/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 25,
            expectedDefense = 101,
            expectedDamage = listOf(5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-6/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-6/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, -6, -6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, -6, 6, 6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-1/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 67,
            expectedDefense = 101,
            expectedDamage = listOf(13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-1/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 67,
            expectedDefense = 101,
            expectedDamage = listOf(13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-1/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/-1/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, -1, -1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, -1, 1, 1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/0/false/",
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
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/0/false/WONDER_ROOM",
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
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(20, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 23, 23, 23, 24),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/0/true/",
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
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/0/true/WONDER_ROOM",
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
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/1/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/1/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(30, 30, 30, 31, 31, 32, 32, 33, 33, 33, 33, 34, 34, 35, 35, 36),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/1/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(45, 45, 46, 47, 48, 48, 48, 49, 49, 50, 51, 51, 51, 52, 53, 54),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/1/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(1, 1, 1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-1, 1, -1, -1, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(45, 45, 46, 47, 48, 48, 48, 49, 49, 50, 51, 51, 51, 52, 53, 54),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/6/false/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage = listOf(79, 80, 81, 82, 83, 84, 84, 86, 87, 87, 88, 90, 90, 91, 92, 93),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/6/false/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = false,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage = listOf(79, 80, 81, 82, 83, 84, 84, 86, 87, 87, 88, 90, 90, 91, 92, 93),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/6/true/",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage =
                listOf(
                    118,
                    120,
                    121,
                    123,
                    124,
                    126,
                    127,
                    129,
                    129,
                    131,
                    132,
                    134,
                    135,
                    137,
                    138,
                    140,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Chip Away/6/true/WONDER_ROOM",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(6, 6, 6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            defender =
                StatReferencePokemon(
                    id = PokemonId("Mew"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(-6, 6, -6, -6, 0),
                    ability = AbilityId("Illuminate"),
                    item = null,
                    boostedStat = null,
                    canEvolve = false,
                ),
            move =
                Move(
                    MoveId("ChipAway"),
                    PokemonType.NORMAL,
                    70,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field =
                BattleField(
                    weather = null,
                    terrain = null,
                    effects = EnumFlags(FieldEffect.WONDER_ROOM),
                ),
            critical = true,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage =
                listOf(
                    118,
                    120,
                    121,
                    123,
                    124,
                    126,
                    127,
                    129,
                    129,
                    131,
                    132,
                    134,
                    135,
                    137,
                    138,
                    140,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
    )
