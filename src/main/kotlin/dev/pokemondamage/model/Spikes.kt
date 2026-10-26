package dev.pokemondamage.model

/** まきびしの設置回数と、登場時に失う最大HPの割合。 */
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
