package dev.pokemondamage.math

import dev.pokemondamage.model.ModifierTrace

/** A snapshot: subsequent stage accumulation cannot change an earlier trace. */
internal class TracedValue(val value: Int, trace: List<ModifierTrace>) {
    val trace: List<ModifierTrace> = java.util.List.copyOf(trace)
}
