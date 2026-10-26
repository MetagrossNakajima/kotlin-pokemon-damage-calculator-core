package dev.pokemondamage

import dev.pokemondamage.model.*
import kotlin.test.*

class SourceAbilityContractTest {
    private val pokemon =
        PokemonState(
            PokemonProfile(PokemonId("Mew"), PokemonTypes(PokemonType.NORMAL), PokemonWeight(100)),
            Stats(200, 100, 100, 100, 100, 100),
        )

    @Test
    fun `AbilityId WaveShield halves contact damage and preserves noncontact damage`() {
        val ordinary = listOf(46, 46, 48, 48, 48, 49, 49, 51, 51, 51, 52, 52, 52, 54, 54, 55)
        val reduced = listOf(23, 23, 24, 24, 24, 24, 24, 25, 25, 25, 26, 26, 26, 27, 27, 27)
        for (enabled in listOf(false, true)) for (contact in listOf(false, true)) for (category in
            Category.entries) {
            val defender = pokemon.copy(ability = if (enabled) AbilityId("WaveShield") else null)
            val move =
                Move(
                    MoveId("Tackle"),
                    PokemonType.NORMAL,
                    80,
                    category,
                    flags = if (contact) EnumFlags(MoveFlag.CONTACT) else EnumFlags(),
                )
            val result =
                assertIs<Calculation.Success<DamageResult>>(
                        calculateDamage(DamageRequest(pokemon, defender, move)),
                    )
                    .value
                    .hit
            assertEquals(
                if (enabled && contact) reduced else ordinary,
                result.rolls,
                "enabled=$enabled contact=$contact category=$category",
            )
        }
    }

    @Test
    fun `AbilityId Sturdy blocks OHKO and respects suppression and Ability Shield`() {
        val moves =
            mapOf(
                "Fissure" to PokemonType.GROUND,
                "SheerCold" to PokemonType.ICE,
                "HornDrill" to PokemonType.NORMAL,
                "Guillotine" to PokemonType.NORMAL,
            )
        for ((name, type) in moves) for (mold in listOf(false, true)) for (gas in
            listOf(false, true)) for (shield in listOf(false, true)) {
            val a = pokemon.copy(ability = if (mold) AbilityId("MoldBreaker") else null)
            val d =
                pokemon.copy(
                    currentHp = 101,
                    ability = AbilityId("Sturdy"),
                    item = if (shield) ItemId("AbilityShield") else null,
                )
            val field =
                BattleField(
                    effects = if (gas) EnumFlags(FieldEffect.NEUTRALIZING_GAS) else EnumFlags(),
                )
            val request = DamageRequest(a, d, Move(MoveId(name), type, 0, Category.PHYSICAL), field)
            val actual =
                assertIs<Calculation.Success<DamageResult>>(calculateDamage(request))
                    .value
                    .hit
                    .rolls
            assertEquals(
                listOf(if (shield || !mold && !gas) 0 else 101),
                actual,
                "$name mold=$mold gas=$gas shield=$shield",
            )
            val control =
                assertIs<Calculation.Success<DamageResult>>(
                        calculateDamage(request.copy(defender = d.copy(ability = null))),
                    )
                    .value
                    .hit
                    .rolls
            assertEquals(listOf(101), control, "without Sturdy the move removes the current HP")
            val fixed =
                assertIs<Calculation.Success<DamageResult>>(
                        calculateDamage(
                            request.copy(
                                move =
                                    Move(
                                        MoveId("SeismicToss"),
                                        PokemonType.FIGHTING,
                                        0,
                                        Category.PHYSICAL,
                                    ),
                            ),
                        ),
                    )
                    .value
                    .hit
                    .rolls
            assertEquals(listOf(50), fixed, "Sturdy does not block ordinary fixed damage")
        }
    }
}
