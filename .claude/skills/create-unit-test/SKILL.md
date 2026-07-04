---
name: create-unit-test
description: こよみのカルネ（Kotlin/Android, Jetpack Compose）プロジェクトでユニットテストコードを作成するスキル。テストフレームワークはKotest（FunSpecスタイル）、モックはMockKを使用し、正常系・異常系・(入力を受け取る対象であれば)境界値のテストケースを必ず含めて生成する。「テストを書いて」「テストケースを追加して」「〇〇のユニットテストを作って」「このクラス/関数のテストが欲しい」「テストを網羅的にして」など、Kotlinのクラス・関数に対するテスト作成や追加を求められたら、明示的に "Kotest" と言われていなくても必ずこのスキルを使う。build.gradle.ktsにKotest/MockKの依存がまだ無い場合は、このスキルが自動的にセットアップする。
---

# ユニットテスト作成（Kotest）

こよみのカルネプロジェクトのKotlinコード（データクラス、バリデーション関数、UseCase、Repository実装、ViewModelなど）に対して、[Kotest](https://kotest.io/)を用いたユニットテストを作成する。

対象は「ロジックを持つKotlinコード」。`views/` 配下のComposable関数そのものの見た目・描画確認は対象外。ただし、ViewModelの状態遷移やUseCase・バリデーションロジックなど、Composableから呼ばれる純粋なロジック部分は対象になる。

## 進め方

1. テスト対象のコードを読み、公開されている関数・メソッドの入出力・例外送出条件・状態遷移を把握する。
2. [依存関係のセットアップ](#依存関係のセットアップkotestmockk)を確認し、未導入なら追加する。
3. テスト対象と同じパッケージ構成で、[テストファイルの配置](#テストファイルの配置と命名)に従いテストファイルを作成する。
4. [必須のテストケース](#必須のテストケース)に沿ってテストを書く。
5. 可能であれば `./gradlew test` を実行し、作成したテストが期待通りに成否判定されることを確認する。

## 依存関係のセットアップ（Kotest/MockK）

`app/build.gradle.kts` と `gradle/libs.versions.toml` を確認し、Kotest/MockKが未導入であれば以下を追加する。

`gradle/libs.versions.toml`:

```toml
[versions]
kotest = "5.9.1"
mockk = "1.13.13"

[libraries]
kotest-runner-junit5 = { group = "io.kotest", name = "kotest-runner-junit5", version.ref = "kotest" }
kotest-assertions-core = { group = "io.kotest", name = "kotest-assertions-core", version.ref = "kotest" }
kotest-property = { group = "io.kotest", name = "kotest-property", version.ref = "kotest" }
mockk = { group = "io.mockk", name = "mockk", version.ref = "mockk" }
```

`app/build.gradle.kts` の `dependencies` に追加:

```kotlin
testImplementation(libs.kotest.runner.junit5)
testImplementation(libs.kotest.assertions.core)
testImplementation(libs.kotest.property)
testImplementation(libs.mockk)
```

Kotestは内部でJUnit Platform（JUnit5）を使って実行されるため、`android { }` ブロックに以下を追加してテストランナーを切り替える（既存のJUnit4テスト `ExampleUnitTest.kt` はそのままでは実行できなくなるため、移行が必要になった場合はユーザーに確認する）。

```kotlin
android {
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}
```

依存関係を追加した場合は、Gradle Syncが必要になる旨をユーザーに伝える。

## テストファイルの配置と命名

- 配置場所: `app/src/test/java/com/iroha71/koyomi_carnet/` 配下に、テスト対象と同じパッケージ構成で置く（例: `app/src/main/java/com/iroha71/koyomi_carnet/views/Home.kt` 内のロジックなら `app/src/test/java/com/iroha71/koyomi_carnet/views/HomeTest.kt`）。
- ファイル名: `<テスト対象クラス・ファイル名>Test.kt`
- 基本は1テスト対象につき1ファイル。関連する複数の小さな関数をまとめたユーティリティファイルの場合は、ファイル単位で1テストファイルにまとめてよい。

## Kotestのテストスタイル: FunSpec

このプロジェクトでは `FunSpec` を使う。`context` でテスト対象のシチュエーション（正常系・異常系・境界値など）をグループ化し、`test` で個々のケースを書く。アサーションは `kotest-assertions-core` の `shouldBe` / `shouldThrow` などを使う。

```kotlin
package com.iroha71.koyomi_carnet.budget

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BudgetValidatorTest : FunSpec({

    context("正常系") {
        test("上限以下の金額であれば true を返す") {
            validateAmount(1_000, max = 10_000) shouldBe true
        }
    }

    context("異常系") {
        test("負の金額を渡すと IllegalArgumentException がスローされる") {
            shouldThrow<IllegalArgumentException> {
                validateAmount(-1, max = 10_000)
            }
        }
    }

    context("境界値") {
        test("上限ちょうどの金額は許可される") {
            validateAmount(10_000, max = 10_000) shouldBe true
        }

        test("上限を1超えた金額は拒否される") {
            shouldThrow<IllegalArgumentException> {
                validateAmount(10_001, max = 10_000)
            }
        }
    }
})
```

## 必須のテストケース

対象が何であっても、以下の観点を必ず含める。

### 1. 正常系テスト

正しい入力値・想定される操作で、期待通りの結果になることを確認する。戻り値だけでなく、状態を持つ対象（ViewModelなど）であれば更新後の状態も確認する。

### 2. 異常系テスト

想定範囲外の入力・操作（null、空文字列、負数、不正なフォーマット、あり得ない状態遷移など）に対して、例外がスローされる／エラーを表す戻り値になる／エラー分岐に入るなど、実装として意図された振る舞いになることを確認する。「何も検証されていない（例外が握りつぶされて正常終了する）」ことを異常系テストの合格にしない。

### 3. 境界値テスト（入力を受け取る対象のみ）

対象が引数・入力を受け取り、かつその値に閾値（上限・下限・許容範囲など）がある場合は、以下の2ケースを必ずセットで用意する。

- 閾値ちょうどの値 → 正常に処理されること
- 閾値を1つ超えた値（上限+1、下限-1など、閾値の外側）→ 適切にエラー処理・分岐が行われること

引数を取らない処理や、閾値の概念が存在しない入力（enumの網羅など）には境界値テストは不要。

## モック: MockK

Repository・DataStore・外部APIクライアントなど、テスト対象が他のクラスに依存している場合はMockKでテストダブルを用意する。値の入れ物でしかないデータクラスや、依存を持たない純粋関数にはモックを使わず直接呼び出してテストする。
