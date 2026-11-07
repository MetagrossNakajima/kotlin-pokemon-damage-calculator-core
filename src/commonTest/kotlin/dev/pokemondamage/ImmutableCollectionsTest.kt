package dev.pokemondamage

import dev.pokemondamage.collections.ImmutableCollections
import dev.pokemondamage.math.BigInteger
import dev.pokemondamage.math.toBigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class ImmutableCollectionsTest {
    @Test
    fun `snapshots preserve nullable map entry equality hash and iteration contracts`() {
        val source = linkedMapOf<String?, Int?>("hit" to 2, null to null, "miss" to null)
        val snapshot = ImmutableCollections.unmodifiableMap(source)
        source["hit"] = 99
        source.remove("miss")
        assertEquals(2, snapshot["hit"])
        assertTrue(snapshot.containsKey("miss"))
        assertFalse(snapshot.containsKey("absent"))
        assertEquals(3, snapshot.size)
        val expected = linkedMapOf<String?, Int?>("hit" to 2, null to null, "miss" to null)
        assertEquals(expected, snapshot)
        assertEquals(expected.hashCode(), snapshot.hashCode())
        for ((entry, ordinary) in snapshot.entries.zip(expected.entries)) {
            assertEquals(ordinary, entry)
            assertEquals(entry, ordinary)
            assertEquals(ordinary.hashCode(), entry.hashCode())
            assertEquals(ordinary.toString(), entry.toString())
        }
        val hit = snapshot.entries.first()
        assertNotEquals<Any?>(hit, null)
        assertNotEquals<Any>(hit, "hit=2")
        assertNotEquals(hit, mapOf("other" to 2).entries.first())
        assertNotEquals(hit, mapOf("hit" to 3).entries.first())
        val iterator = snapshot.entries.iterator()
        repeat(3) { iterator.next() }
        assertFalse(iterator.hasNext())
        assertFailsWith<NoSuchElementException> { iterator.next() }
        val empty = ImmutableCollections.unmodifiableSet(emptySet<Int>()).iterator()
        assertFalse(empty.hasNext())
        assertFailsWith<NoSuchElementException> { empty.next() }
    }

    @Test
    fun `long weights cross the signed machine boundary without overflow`() {
        assertEquals(
            BigInteger("9223372036854775808"),
            Long.MAX_VALUE.toBigInteger() + BigInteger.ONE,
        )
    }
}
