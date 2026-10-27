# kotlin-pokemon-damage-calculator-core

ポケモンのダメージ計算用 Kotlin/JVM ライブラリ。

- `calculateDamage(request)`：単発のダメージ分布を計算
- `calculateCombinedDamage(request)`：連続攻撃のHP推移・撃破率・確定数を計算

## 別プロジェクトから利用する

GitHub ReleasesのJARをGradleから直接取得できます。公開リポジトリでは認証は不要です。
利用先はJDK 26と、互換性のあるKotlinコンパイラ（本ライブラリは2.4.21）を使用してください。
以下は`v0.1.0`を公開した後に利用できる設定例です。

利用先の`build.gradle.kts`に追加します。
リポジトリを`settings.gradle.kts`に集約している場合は、
`repositories`の内容を`dependencyResolutionManagement.repositories`に追加してください。

```kotlin
repositories {
    mavenCentral()
    exclusiveContent {
        forRepository {
            ivy {
                name = "pokemonDamageReleases"
                url = uri(
                    "https://github.com/MetagrossNakajima/" +
                        "kotlin-pokemon-damage-calculator-core/releases/download",
                )
                patternLayout {
                    artifact("v[revision]/[artifact]-[revision](-[classifier]).[ext]")
                }
                metadataSources { artifact() }
            }
        }
        filter {
            includeModule("dev.pokemondamage", "kotlin-pokemon-damage-calculator-core")
        }
    }
}

dependencies {
    implementation("dev.pokemondamage:kotlin-pokemon-damage-calculator-core:0.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.4.21")
}
```

`dev.pokemondamage`はこの取得設定内で使う識別子です。Maven Centralへの登録は不要です。
Gradleが指定バージョンのJARをダウンロードしてキャッシュするため、手動コピーは不要です。
JARには依存関係のメタデータがないので、Kotlin標準ライブラリは利用先で明示します。
更新時は依存関係のバージョンを公開済みのものに変更してください。
非公開リポジトリからの取得には別途認証が必要で、この例は公開リポジトリ向けです。

## リリース

`.github/workflows/release.yml`は、`v0.1.0`のような`vメジャー.マイナー.パッチ`タグのpushで起動します。
テスト・カバレッジ・整形チェックの成功後、GitHub Releaseを作成し、
本体JAR・ソースJAR・`SHA256SUMS`を添付します。両JARにはMITライセンスを同梱します。
バージョンはタグから設定するため、通常開発用の`0.1.0-SNAPSHOT`を書き換える必要はありません。
本名の登録や公開用トークンの追加は不要で、Actionsの`GITHUB_TOKEN`を使います。

変更をコミットし、GitHubへpushした後に実行してください。

```sh
git tag v0.1.0
git push origin v0.1.0
```

公開済みタグやReleaseは上書きせず、変更時は新しいバージョンを作成してください。
ビルド段階で失敗した場合は原因を解消して再実行できます。
Release作成後の再実行では既存Releaseを上書きしません。

公開せずにリリース用ビルドを確認する場合：

```sh
mise exec -- ./gradlew clean build spotlessCheck -PreleaseVersion=0.1.0
```

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

- `PokemonState.ability`には発動済みの特性を指定します。天候・HP・状態異常による発動条件は推定しません。
- 連続計算は指定された固定の攻撃分布を使います。途中のHP変化によるダメージの再計算は行いません。
- 不正な入力はモデル生成時に`InputValidationException`になります。`validate { ... }`で`Validation.Invalid`として受け取れます。未対応の技や計算量上限超過は`Calculation.Failure`で返します。

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
