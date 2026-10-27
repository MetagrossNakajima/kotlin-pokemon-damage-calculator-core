# kotlin-pokemon-damage-calculator-core

ポケモンのダメージ計算用 Kotlin Multiplatform ライブラリ。

計算実装は `commonMain` に置き、Androidから利用するJVMターゲットと
iOS実機・Apple Siliconシミュレーターのターゲットを提供します。
任意精度整数は `dev.pokemondamage.math.BigInteger` を使います。
Java専用APIには依存しません。

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

## 状態とルールのモデル

段階や回数は専用の型で指定します。整数からの変換時に範囲を検証します。

```kotlin
val hazards = EntryHazards(spikes = Spikes.TWO_LAYERS)
val stages = StatStages(attack = StatStage(2), defense = StatStage(-1))
val pokemon = attacker.copy(
    stages = stages,
    status = Status.TOXIC,
    toxicCounter = ToxicCounter(3),
    faintedAllies = FaintedAllies(2),
    timesHit = TimesHit(6),
)
```

整数から変換する場合は`Spikes.fromLayers(value)`、`StatStages.fromValues(...)`を使えます。
`Attack.fromAccuracy`の命中判定方式は`accuracyMode`で指定します
（`AccuracyMode.ONCE_PER_ATTACK`／`AccuracyMode.UNTIL_FIRST_MISS`）。

## 計算仕様

このライブラリは、指定した条件で攻撃が与えるダメージ量を調べるためのものです。
利用者が技や能力値、特性、持ち物を変えたときのダメージを比較できることを重視し、
対戦全体の進行や技の成立条件を再現するシミュレーターは目指していません。

ただし、ダメージ計算と技の成立判定の境界は、すべての効果で明確に分けられるわけではありません。
タイプ相性や、ふゆうによるじめん技の無効は、ダメージ計算に含めます。
一方、テイルアーマーによる先制技の阻止は呼び出し側の判定に任せ、
このライブラリでは指定された技のダメージを計算します。
0ダメージになる効果を一律に省くのではなく、ダメージ比較の用途に合わせて対応範囲を決めます。

- `PokemonState.ability`には発動済みの特性を指定します。天候・HP・状態異常による発動条件は推定しません。
- 連続計算は指定された固定の攻撃分布を使います。途中のHP変化によるダメージの再計算は行いません。
- 不正な入力はモデル生成時に`InputValidationException`になります。`validate { ... }`で`Validation.Invalid`として受け取れます。未対応の技や計算量上限超過は`Calculation.Failure`で返します。

## 開発

JDK 26（mise）・Kotlin 2.4.21・Gradle Wrapper 9.7.0を使用します。
JVMバイトコードはAndroid互換の17を対象にします。miseを導入後、次を実行してください。

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

整形にはSpotless経由でktlintの標準ルールを使用し、行幅は100文字に設定しています。
複数行の`if` / `else`には`{}`を付けます。
1行に収まる場合は`{}`を省略できます。

### 特殊技の分布と能力ランク

`StatStages`の`accuracy`・`evasion`で命中率・回避率ランクも指定できます。
アシストパワー／つけあがるは、これらを含む7項目の正のランクを威力に反映します。
命中判定自体は引き続き`Attack.fromAccuracy`に渡す命中率で指定します。

シェルアームズは、端数処理後の基礎ダメージが同値なら物理・特殊を各50%で計算します。
この場合、`DamageResult.hit`が特殊側、`alternativeHit`が物理側の計算根拠を保持し、
`distribution`・`min`・`max`・割合には両方の結果を反映します。
連続計算へは`DamageResult.distribution`を渡してください。

### 共通コードの検証

`mise run test` は共通テストとJVM上の参照値テストを実行します。
`mise run metadata` は共通メタデータをコンパイルしてJVM専用APIの混入を検出します。
iOSの実行テストにはmacOSとXcodeが必要です。Linux上ではiOS実行テストは行いません。

任意精度整数の実装には `com.ionspin.kotlin:bignum:0.3.10` を使用します。
元のJava実装との演算比較と、非正規化数・偶数丸め・命中率0%を含む既存テストで
計算仕様を検証します。
