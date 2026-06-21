package com.iroha71.koyomi_carnet.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.iroha71.koyomi_carnet.R

private val GeneiLatemin = FontFamily(
    Font(R.font.genei_latemin_v2)
)

// Material3 のデフォルト Typography をベースに、フォントだけ差し替える。
// fontSize/lineHeight/letterSpacing 等のトークンはライブラリのデフォルトに追従させる。
private val default = Typography()

val Typography = default.copy(
    displayLarge   = default.displayLarge.copy(fontFamily = GeneiLatemin),
    displayMedium  = default.displayMedium.copy(fontFamily = GeneiLatemin),
    displaySmall   = default.displaySmall.copy(fontFamily = GeneiLatemin),
    headlineLarge  = default.headlineLarge.copy(fontFamily = GeneiLatemin),
    headlineMedium = default.headlineMedium.copy(fontFamily = GeneiLatemin),
    headlineSmall  = default.headlineSmall.copy(fontFamily = GeneiLatemin),
    titleLarge     = default.titleLarge.copy(fontFamily = GeneiLatemin),
    titleMedium    = default.titleMedium.copy(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal),
    titleSmall     = default.titleSmall.copy(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal),
    bodyLarge      = default.bodyLarge.copy(fontFamily = GeneiLatemin),
    bodyMedium     = default.bodyMedium.copy(fontFamily = GeneiLatemin),
    bodySmall      = default.bodySmall.copy(fontFamily = GeneiLatemin),
    labelLarge     = default.labelLarge.copy(fontFamily = GeneiLatemin),
    labelMedium    = default.labelMedium.copy(fontFamily = GeneiLatemin),
    labelSmall     = default.labelSmall.copy(fontFamily = GeneiLatemin),
)
