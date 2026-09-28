package com.example.learningcontract.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryGreen,
    onPrimary = DarkBackgroundGreen,
    primaryContainer = SecondaryGreen,
    onPrimaryContainer = DarkOnSurfaceGreen,
    secondary = DarkPrimaryGreen,
    background = DarkBackgroundGreen,
    onBackground = DarkOnSurfaceGreen,
    surface = DarkSurfaceGreen,
    onSurface = DarkOnSurfaceGreen
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryGreen,
    onPrimary = OnPrimaryGreen,
    primaryContainer = PrimaryContainerGreen,
    onPrimaryContainer = OnPrimaryContainerGreen,
    secondary = SecondaryGreen,
    onSecondary = OnSecondaryGreen,
    secondaryContainer = SecondaryContainerGreen,
    onSecondaryContainer = OnSecondaryContainerGreen,
    background = BackgroundGreen,
    onBackground = OnBackgroundGreen,
    surface = SurfaceGreen,
    onSurface = OnSurfaceGreen,
    surfaceVariant = SurfaceVariantGreen,
    onSurfaceVariant = OnSurfaceVariantGreen
)

@Composable
fun LearningContractTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Disable dynamic color to keep our custom green theme consistent
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}