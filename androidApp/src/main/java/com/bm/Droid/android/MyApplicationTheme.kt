package com.bm.Droid.android

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("ConflictingOnColor")
@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFF01A7F2),
            onPrimary = Color(0xFFFFFFFF),
            secondary = Color(0xFF039BE5),
            onSecondary = Color(0xFFFFFFFF),
            background = Color(0xFF0D47A1),
            onBackground = Color(0xFF00E676),
            error = Color(0xFFF44336),
            primaryVariant = Color(0xFF484848),
        )
    } else {
        lightColors(
            primary = Color(0xFF01A7F2),
            onPrimary = Color(0xFFFFFFFF),
            secondary = Color(0xFFFFFFFF),
            onSecondary = Color(0xFF01A7F2),
            background = Color(0xFF01A7F2),
            onBackground = Color(0xFF00E676),
            error = Color(0xFFF44336),
            primaryVariant = Color(0xFF484848),
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
