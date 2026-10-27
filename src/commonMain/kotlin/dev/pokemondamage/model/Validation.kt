package dev.pokemondamage.model

import dev.pokemondamage.collections.ImmutableCollections

/** 入力の検証エラーと、妥当な入力での計算失敗を区別する。 */
enum class ValidationCode {
    REQUIRED,
    OUT_OF_RANGE,
    UNKNOWN_VALUE,
    DUPLICATE,
    INCONSISTENT,
}

data class ValidationError(
    val path: String,
    val code: ValidationCode,
)

/** Kotlinの列挙名を解析する。大文字・小文字を区別し、未知の値でも例外を投げない。 */
fun <E : Enum<E>> validateEnum(
    value: String,
    entries: kotlin.enums.EnumEntries<E>,
): Validation<E> {
    for (entry in entries) {
        if (entry.name == value) {
            return Validation.Valid(entry)
        }
    }
    return Validation.Invalid(listOf(ValidationError("value", ValidationCode.UNKNOWN_VALUE)))
}

sealed interface Validation<out T> {
    data class Valid<T>(
        val value: T,
    ) : Validation<T>

    class Invalid(
        errors: List<ValidationError>,
    ) : Validation<Nothing> {
        val errors: List<ValidationError> = ImmutableCollections.unmodifiableList(errors)

        init {
            require(this.errors.isNotEmpty()) { "validation errors must not be empty" }
        }
    }
}

/** 直接生成する場合も不正な入力は拒否する。[validate]でエラーの詳細を確認できる。 */
class InputValidationException internal constructor(
    val failure: Validation.Invalid,
) : IllegalArgumentException(failure.errors.joinToString { "${it.path}: ${it.code}" })

/** モデルの検証エラーだけを捕捉し、実装上の不具合や無関係な例外は呼び出し側へ伝える。 */
fun <T> validate(
    path: String = "",
    build: () -> T,
): Validation<T> =
    try {
        Validation.Valid(build())
    } catch (error: InputValidationException) {
        if (path.isEmpty()) {
            error.failure
        } else {
            Validation.Invalid(
                error.failure.errors.map {
                    it.copy(path = "$path.${it.path}")
                },
            )
        }
    }

/** 個別に検証した入力を組み合わせ、両方のエラーを入力順に保持する。 */
fun <A, B, R> Validation<A>.zip(
    other: Validation<B>,
    build: (A, B) -> R,
): Validation<R> =
    when (this) {
        is Validation.Valid -> {
            when (other) {
                is Validation.Valid -> validate { build(value, other.value) }
                is Validation.Invalid -> other
            }
        }

        is Validation.Invalid -> {
            when (other) {
                is Validation.Valid -> this
                is Validation.Invalid -> Validation.Invalid(errors + other.errors)
            }
        }
    }
