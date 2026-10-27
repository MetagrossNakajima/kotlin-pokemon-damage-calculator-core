package dev.pokemondamage.collections

/** Defensive snapshots that never expose mutable backing collections. */
internal object ImmutableCollections {
    fun <E> unmodifiableList(source: List<E>): List<E> = SnapshotList(source.toList())

    fun <E> unmodifiableSet(source: Set<E>): Set<E> = SnapshotSet(source.toList())

    fun <K, V> unmodifiableMap(source: Map<K, V>): Map<K, V> = SnapshotMap(source)
}

private class SnapshotSet<E>(
    private val elements: List<E>,
) : AbstractSet<E>() {
    override val size: Int get() = elements.size

    override fun iterator(): Iterator<E> =
        object : Iterator<E> {
            private var index = 0

            override fun hasNext(): Boolean = index < elements.size

            override fun next(): E {
                if (!hasNext()) throw NoSuchElementException()
                return elements[index++]
            }
        }
}

private class SnapshotMap<K, V>(
    source: Map<K, V>,
) : AbstractMap<K, V>() {
    private val lookup = source.toMap()
    override val size: Int get() = lookup.size

    override fun get(key: K): V? = lookup[key]

    override fun containsKey(key: K): Boolean = lookup.containsKey(key)

    override val entries: Set<Map.Entry<K, V>> =
        SnapshotSet(
            source.map { (key, value) -> Entry(key, value) },
        )

    private class Entry<K, V>(
        override val key: K,
        override val value: V,
    ) : Map.Entry<K, V> {
        override fun equals(other: Any?): Boolean =
            other is Map.Entry<*, *> && key == other.key && value == other.value

        override fun hashCode(): Int = (key?.hashCode() ?: 0) xor (value?.hashCode() ?: 0)

        override fun toString(): String = "$key=$value"
    }
}

internal fun <K : Comparable<K>, V> Map<K, V>.sortedByKey(): Map<K, V> =
    entries.sortedBy { it.key }.associate { it.key to it.value }

internal fun <K, V : Any> MutableMap<K, V>.mergeWeight(
    key: K,
    value: V,
    combine: (V, V) -> V,
) {
    this[key] = this[key]?.let { combine(it, value) } ?: value
}

private class SnapshotList<E>(
    private val elements: List<E>,
) : AbstractList<E>() {
    override val size: Int get() = elements.size

    override fun get(index: Int): E = elements[index]
}
