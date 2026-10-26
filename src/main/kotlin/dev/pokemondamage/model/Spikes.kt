package dev.pokemondamage.model

/** Placement count and the corresponding fraction of maximum HP lost on entry. */
enum class Spikes(
    val layers: Int,
    val damageDenominator: Int?,
) {
    NONE(0, null),
    ONE_LAYER(1, 8),
    TWO_LAYERS(2, 6),
    THREE_LAYERS(3, 4),
    ;

    companion object {
        fun fromLayers(layers: Int): Spikes {
            requireInput(layers in 0..3, "layers", ValidationCode.OUT_OF_RANGE)
            return entries[layers]
        }
    }
}
