package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val ColoursTattooColorScheme = darkColorScheme(
    primary = AntiqueGold,
    onPrimary = DeepCharcoal,
    primaryContainer = CardBackground,
    onPrimaryContainer = WarmIvory,
    secondary = AntiqueGoldHover,
    onSecondary = DeepCharcoal,
    secondaryContainer = SecondaryCharcoal,
    onSecondaryContainer = WarmIvory,
    tertiary = AntiqueGold,
    onTertiary = DeepCharcoal,
    background = DeepCharcoal,
    onBackground = WarmIvory,
    surface = SecondaryCharcoal,
    onSurface = WarmIvory,
    surfaceVariant = CardBackground,
    onSurfaceVariant = SecondaryText,
    outline = BorderColor,
    outlineVariant = BorderColor
)

@Composable
fun ColoursTattooTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = DeepCharcoal.toArgb()
            window.navigationBarColor = DeepCharcoal.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
        }
    }

    MaterialTheme(
        colorScheme = ColoursTattooColorScheme,
        typography = Typography,
        content = content
    )
}
