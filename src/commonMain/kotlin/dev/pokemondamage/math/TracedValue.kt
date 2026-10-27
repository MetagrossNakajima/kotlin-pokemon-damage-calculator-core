package dev.pokemondamage.math

import dev.pokemondamage.collections.ImmutableCollections
import dev.pokemondamage.model.ModifierStage
import dev.pokemondamage.model.ModifierTrace

/** 計算途中の値と履歴。後続の補正を追加しても過去の履歴は変わらない。 */
internal class TracedValue(
    val value: Int,
    trace: List<ModifierTrace>,
) {
    val trace: List<ModifierTrace> = ImmutableCollections.unmodifiableList(trace)

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
