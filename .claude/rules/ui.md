# UI アーキテクチャ

以下のパス表記は `app/src/main/java/com/iroha71/koyomi_carnet/` からの相対パス。

- **UI**: Jetpack Compose + Material3。`MainActivity` が `KoyomicarnetTheme` でラップした `AppNavHost` を唯一のエントリポイントとして描画する。
- **画面遷移**: `routes/AppNavHost.kt` に `NavHost` を定義し、`routes/Routes.kt` の `@Serializable` object（型安全Navigation）をルートとして参照する。新しい画面を追加する際は、Routesにルートを追加し、AppNavHostに`composable<...>`を登録する。
- **画面共通レイアウト**: `layouts/AppLayout.kt` の `AppLayout` composable が `Scaffold`（TopAppBar + Menu アイコン）を提供する。各画面（`views/` 配下）はこの `AppLayout` でラップして実装する。
- **画面実装**: `views/` 配下に画面ごとの `@Composable` 関数を置く（例: `Home.kt`, `About.kt`）。文字列は `stringResource` 経由で `res/values/strings.xml` から取得する（ハードコードしない）。
- **テーマ**: `ui/theme/` にColor/Theme/Typeを配置。`BrandPrimary` をDynamic Colorと `harmonizeWithPrimary()` で調和させて使用する。
