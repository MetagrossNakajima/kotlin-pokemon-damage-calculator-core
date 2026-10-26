package dev.pokemondamage

import dev.pokemondamage.model.EnumFlags
import dev.pokemondamage.model.MoveFlag
import dev.pokemondamage.model.PokemonFlag
import dev.pokemondamage.model.PokemonFlags
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class ImmutableFlagsTest {
    @Test
    fun `enum flags deduplicate and expose an immutable set`() {
        val input = arrayOf(MoveFlag.PUNCH, MoveFlag.CONTACT, MoveFlag.PUNCH)
        val flags = EnumFlags(*input)
        input[0] = MoveFlag.SOUND
        assertEquals(setOf(MoveFlag.PUNCH, MoveFlag.CONTACT), flags.values)
        assertTrue(MoveFlag.PUNCH in flags)
        assertFalse(MoveFlag.SOUND in flags)
        assertFailsWith<UnsupportedOperationException> { (flags.values as MutableSet).clear() }
        assertEquals(EnumFlags(MoveFlag.CONTACT, MoveFlag.PUNCH), flags)
        assertEquals(EnumFlags(MoveFlag.CONTACT, MoveFlag.PUNCH).hashCode(), flags.hashCode())
        assertNotEquals(EnumFlags(MoveFlag.CONTACT), flags)
        assertFalse(flags.equals(null))
        assertFalse(flags.equals(setOf(MoveFlag.CONTACT, MoveFlag.PUNCH)))
        assertEquals("[PUNCH, CONTACT]", flags.toString())
        assertEquals(emptySet(), EnumFlags<MoveFlag>().values)
    }

    @Test
    fun `pokemon flag overrides preserve absent true and false independently`() {
        val input = mutableMapOf(PokemonFlag.GROUNDED to false, PokemonFlag.MOVES_FIRST to true)
        val flags = PokemonFlags(input)
        input.clear()
        assertEquals(false, flags[PokemonFlag.GROUNDED])
        assertEquals(true, flags[PokemonFlag.MOVES_FIRST])
        assertNull(flags[PokemonFlag.ITEM_REMOVABLE])
        assertEquals(
            mapOf(PokemonFlag.GROUNDED to false, PokemonFlag.MOVES_FIRST to true),
            flags.overrides,
        )
        assertFailsWith<UnsupportedOperationException> { (flags.overrides as MutableMap).clear() }
        val equivalent =
            PokemonFlags(mapOf(PokemonFlag.MOVES_FIRST to true, PokemonFlag.GROUNDED to false))
        assertEquals(equivalent, flags)
        assertEquals(equivalent.hashCode(), flags.hashCode())
        assertNotEquals(PokemonFlags(), flags)
        assertFalse(flags.equals(null))
        assertFalse(flags.equals(flags.overrides))
        assertEquals("{GROUNDED=false, MOVES_FIRST=true}", flags.toString())
        assertNotEquals(PokemonFlags(), PokemonFlags(mapOf(PokemonFlag.GROUNDED to false)))
    }
}
