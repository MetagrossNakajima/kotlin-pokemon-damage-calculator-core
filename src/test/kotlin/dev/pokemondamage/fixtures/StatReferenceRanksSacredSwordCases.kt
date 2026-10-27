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

// Fixed reference expectations for RanksSacredSword. See StatReferenceCases for provenance.
internal fun statReferenceRanksSacredSwordCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceRanksSacredSwordCasesPart1())
    }

private fun statReferenceRanksSacredSwordCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "ranks/Sacred Sword/-6/false/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 25,
            expectedDefense = 101,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-6/false/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-6/true/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-6/true/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-1/false/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 67,
            expectedDefense = 101,
            expectedDamage = listOf(17, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-1/false/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(17, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 21),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-1/true/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/-1/true/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/0/false/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30, 30, 30),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/0/false/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(25, 26, 26, 27, 27, 27, 27, 27, 28, 28, 28, 29, 29, 30, 30, 30),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/0/true/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/0/true/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/1/false/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/1/false/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(38, 39, 39, 39, 40, 40, 41, 42, 42, 42, 42, 43, 44, 44, 45, 45),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/1/true/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 151,
            expectedDefense = 101,
            expectedDamage = listOf(57, 58, 59, 60, 60, 60, 61, 62, 63, 63, 64, 65, 66, 66, 67, 68),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/1/true/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage = listOf(57, 58, 59, 60, 60, 60, 61, 62, 63, 63, 64, 65, 66, 66, 67, 68),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/6/false/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage =
                listOf(
                    102,
                    102,
                    104,
                    105,
                    106,
                    108,
                    108,
                    110,
                    111,
                    112,
                    114,
                    114,
                    116,
                    117,
                    118,
                    120,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/6/false/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
            expectedDamage =
                listOf(
                    102,
                    102,
                    104,
                    105,
                    106,
                    108,
                    108,
                    110,
                    111,
                    112,
                    114,
                    114,
                    116,
                    117,
                    118,
                    120,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/6/true/",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = true,
            expectedAttack = 404,
            expectedDefense = 101,
            expectedDamage =
                listOf(
                    153,
                    154,
                    156,
                    158,
                    159,
                    162,
                    163,
                    165,
                    167,
                    168,
                    171,
                    172,
                    174,
                    176,
                    177,
                    180,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "ranks/Sacred Sword/6/true/WONDER_ROOM",
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
                    MoveId("SacredSword"),
                    PokemonType.NORMAL,
                    90,
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
                    153,
                    154,
                    156,
                    158,
                    159,
                    162,
                    163,
                    165,
                    167,
                    168,
                    171,
                    172,
                    174,
                    176,
                    177,
                    180,
                ),
            controlRole = null,
            expectedControlDamage = null,
        ),
    )
