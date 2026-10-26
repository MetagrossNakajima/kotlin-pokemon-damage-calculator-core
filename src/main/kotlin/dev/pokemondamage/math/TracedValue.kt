package dev.pokemondamage.math

import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace

/** A snapshot: subsequent stage accumulation cannot change an earlier trace. */
internal class TracedValue(
    val value: Int,
    trace: List<ModifierTrace>,
) {
    val trace: List<ModifierTrace> = java.util.List.copyOf(trace)

    fun step(
        id: String,
        stage: ModifierStage,
        numerator: Long,
        denominator: Long,
        after: Int,
    ): TracedValue =
        TracedValue(
            after,
            trace +
                ModifierTrace(
                    id,
                    stage,
                    numerator,
                    denominator,
                    value.toLong(),
                    after.toLong(),
                ),
        )
}
