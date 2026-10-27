package dev.pokemondamage.fixtures

import dev.pokemondamage.model.AbilityId
import dev.pokemondamage.model.BattleField
import dev.pokemondamage.model.Category
import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.ItemId
import dev.pokemondamage.model.Move
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.MoveId
import dev.pokemondamage.model.PokemonId
import dev.pokemondamage.model.PokemonType
import dev.pokemondamage.model.PokemonTypes
import dev.pokemondamage.model.StatStages
import dev.pokemondamage.model.Stats

// Fixed reference expectations for Item. See StatReferenceCases for provenance.
internal fun statReferenceItemCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceItemCasesPart1())
    }

private fun statReferenceItemCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "item/Thick Club/Cubone/Physical",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Cubone"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("ThickClub"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 202,
            expectedDefense = 101,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Thick Club/Cubone/Special",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Cubone"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("ThickClub"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Thick Club/Marowak/Physical",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Marowak"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("ThickClub"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 202,
            expectedDefense = 101,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Thick Club/Marowak/Special",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Marowak"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("ThickClub"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Thick Club/Marowak-Alola/Physical",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Marowak-Alola"),
                    types = PokemonTypes(PokemonType.NORMAL, PokemonType.GHOST),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("ThickClub"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 202,
            expectedDefense = 101,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Thick Club/Marowak-Alola/Special",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Marowak-Alola"),
                    types = PokemonTypes(PokemonType.NORMAL, PokemonType.GHOST),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("ThickClub"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Deep Sea Tooth/Clamperl/Physical",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Clamperl"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("DeepSeaTooth"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Deep Sea Tooth/Clamperl/Special",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Clamperl"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("DeepSeaTooth"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 202,
            expectedDefense = 101,
            expectedDamage = listOf(46, 46, 48, 48, 48, 49, 49, 51, 51, 51, 52, 52, 52, 54, 54, 55),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Light Ball/Pikachu/Physical",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("LightBall"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.PHYSICAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 202,
            expectedDefense = 101,
            expectedDamage = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Light Ball/Pikachu/Special",
            attacker =
                StatReferencePokemon(
                    id = PokemonId("Pikachu"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("LightBall"),
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
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    40,
                    Category.SPECIAL,
                    flags = EnumFlags(MoveFlag.CONTACT),
                ),
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 202,
            expectedDefense = 101,
            expectedDamage = listOf(46, 46, 48, 48, 48, 49, 49, 51, 51, 51, 52, 52, 52, 54, 54, 55),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Eviolite/Pikachu/Physical",
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
                    ability = AbilityId("Illuminate"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Eviolite/Pikachu/Special",
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
                    ability = AbilityId("Illuminate"),
                    item = ItemId("Eviolite"),
                    boostedStat = null,
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Assault Vest/Mew/Physical",
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
                    item = ItemId("AssaultVest"),
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Assault Vest/Mew/Special",
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
                    item = ItemId("AssaultVest"),
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Deep Sea Scale/Clamperl/Physical",
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
                    id = PokemonId("Clamperl"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("DeepSeaScale"),
                    boostedStat = null,
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 14),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Deep Sea Scale/Clamperl/Special",
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
                    id = PokemonId("Clamperl"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("DeepSeaScale"),
                    boostedStat = null,
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 202,
            expectedDamage = listOf(12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 15),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Metal Powder/Ditto/Physical",
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
                    id = PokemonId("Ditto"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("MetalPowder"),
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 202,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "item/Metal Powder/Ditto/Special",
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
                    id = PokemonId("Ditto"),
                    types = PokemonTypes(PokemonType.NORMAL),
                    stats = Stats(200, 101, 101, 101, 101, 101),
                    stages = StatStages.fromValues(0, 0, 0, 0, 0),
                    ability = AbilityId("Illuminate"),
                    item = ItemId("MetalPowder"),
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
            field = BattleField(weather = null, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 28),
            controlRole = null,
            expectedControlDamage = null,
        ),
    )
