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
import dev.pokemondamage.model.Weather

// Fixed reference expectations for Weather. See StatReferenceCases for provenance.
internal fun statReferenceWeatherCases(): List<StatReferenceCase> =
    buildList {
        addAll(statReferenceWeatherCasesPart1())
    }

private fun statReferenceWeatherCasesPart1(): List<StatReferenceCase> =
    listOf(
        StatReferenceCase(
            name = "weather/Sand/Physical",
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
                    types = PokemonTypes(PokemonType.ROCK),
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
            field = BattleField(weather = Weather.SANDSTORM, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 101,
            expectedDamage = listOf(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "weather/Sand/Special",
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
                    types = PokemonTypes(PokemonType.ROCK),
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
            field = BattleField(weather = Weather.SANDSTORM, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 226,
            expectedDamage = listOf(5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "weather/Snow/Physical",
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
                    types = PokemonTypes(PokemonType.ICE),
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
            field = BattleField(weather = Weather.SNOW, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9),
            controlRole = null,
            expectedControlDamage = null,
        ),
        StatReferenceCase(
            name = "weather/Snow/Special",
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
                    types = PokemonTypes(PokemonType.ICE),
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
            field = BattleField(weather = Weather.SNOW, terrain = null, effects = EnumFlags()),
            critical = false,
            expectedAttack = 101,
            expectedDefense = 151,
            expectedDamage = listOf(16, 16, 16, 16, 16, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 19),
            controlRole = null,
            expectedControlDamage = null,
        ),
    )
