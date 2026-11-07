package dev.pokemondamage.model

import kotlin.jvm.JvmInline

/** 大文字・小文字を区別する移植元の識別子。空でなければ独自のIDも指定できる。 */
@JvmInline
value class MoveId(
    val value: String,
) {
    init {
        requireInput(value.isNotEmpty(), "value", ValidationCode.REQUIRED)
    }
}
