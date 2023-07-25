package com.harbourspace.unsplash.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.harbourspace.unsplash.R

private val ApercuFontFamily = FontFamily(
    Font(R.font.apercu_bold_pro, FontWeight.Bold),
    Font(R.font.apercu_medium_pro, FontWeight.Medium),
    Font(R.font.apercu_regular_pro, FontWeight.Normal)
)

private val AdventureFontFamily = FontFamily(
    Font(R.font.adventure, FontWeight.Normal)
)

val fontSizeLarge = 17.sp
val fontSizeMedium = 15.sp
val fontSizeSmall = 13.sp

val Typography = Typography(
    // Text Default
    bodyLarge = TextStyle(
        fontFamily = ApercuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = fontSizeLarge
    ),

    bodyMedium = TextStyle(
        fontFamily = ApercuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = fontSizeMedium
    ),

    bodySmall = TextStyle(
        fontFamily = ApercuFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = fontSizeSmall
    )
)