# kotlin-pokemon-damage-calculator-core

ポケモンのダメージ計算用 Kotlin/JVM ライブラリ。

- `calculateDamage(request)`：単発のダメージ分布を計算
- `calculateCombinedDamage(request)`：連続攻撃のHP推移・撃破率・確定数を計算

## 使用例

能力値はレベル50の実数値を指定します。

```kotlin
import dev.pokemondamage.calculateDamage
import dev.pokemondamage.model.*

val attacker = PokemonState(
    profile = PokemonProfile(
        PokemonId("Mew"),
        PokemonTypes(PokemonType.PSYCHIC),
        PokemonWeight.fromKilograms(4.0),
    ),
    stats = Stats(
        hp = 175,
        attack = 120,
        defense = 120,
        specialAttack = 150,
        specialDefense = 120,
        speed = 120,
    ),
)
val defender = attacker.copy(stats = attacker.stats.copy(specialDefense = 140))
val move = Move(MoveId("Psychic"), PokemonType.PSYCHIC, 90, Category.SPECIAL)

when (val result = calculateDamage(DamageRequest(attacker, defender, move))) {
    is Calculation.Success -> println("${result.value.min}〜${result.value.max}ダメージ")
    is Calculation.Failure -> println("${result.kind}: ${result.path}")
}
```

## 開発

JDK 26を使用します。miseを導入後、次を実行してください。

```sh
mise trust
mise install
mise run build  # ビルド・テスト・カバレッジ検証
```

```sh
mise run test   # テスト
mise run format # Kotlinコードを100文字幅で整形
mise run check  # テスト・カバレッジ100%検証
mise run clean  # ビルド成果物の削除
```
