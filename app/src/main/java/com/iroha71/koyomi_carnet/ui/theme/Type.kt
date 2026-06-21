package com.iroha71.koyomi_carnet.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iroha71.koyomi_carnet.R

// Set of Material typography styles to start with

private val GeneiLatemin = FontFamily(
    Font(R.font.genei_latemin_v2)
)
val Typography = Typography(
    displayLarge  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.25).sp),
    displayMedium = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 45.sp, lineHeight = 52.sp, letterSpacing = 0.sp),
    displaySmall  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 36.sp, lineHeight = 44.sp, letterSpacing = 0.sp),
    headlineLarge  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 32.sp, lineHeight = 40.sp, letterSpacing = 0.sp),
    headlineMedium = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 28.sp, lineHeight = 36.sp, letterSpacing = 0.sp),
    headlineSmall  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 24.sp, lineHeight = 32.sp, letterSpacing = 0.sp),
    titleLarge  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 22.sp, lineHeight = 28.sp, letterSpacing = 0.sp),
    titleMedium = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.15.sp),
    titleSmall  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    bodyLarge  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.5.sp),
    bodyMedium = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.25.sp),
    bodySmall  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp),
    labelLarge  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    labelMedium = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
    labelSmall  = TextStyle(fontFamily = GeneiLatemin, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
)