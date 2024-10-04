package oilpay.mobile.foundation.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

internal val md_theme_light_primary = Color(0xFF1483FF)
internal val md_theme_light_onPrimary = Color(0xFFFFFFFF)
internal val md_theme_light_primaryContainer = Color(0xF000000)
internal val md_theme_light_onPrimaryContainer = Color(0xFF001F26)
internal val md_theme_light_secondary = Color(0xFF292929)
internal val md_theme_light_onSecondary = Color(0xFFE1E0E6)
internal val md_theme_light_secondaryContainer = Color(0xFF6FF6FE)
internal val md_theme_light_onSecondaryContainer = Color(0xFF002022)
internal val md_theme_light_tertiary = Color(0xFFFFFFFF)
internal val md_theme_light_onTertiary = Color(0xFFFFFFFF)
internal val md_theme_light_tertiaryContainer = Color(0xFFFFDCC2)
internal val md_theme_light_onTertiaryContainer = Color(0xFF2E1500)
internal val md_theme_light_error = Color(0xFFBA1A1A)
internal val md_theme_light_errorContainer = Color(0xFFFFDAD6)
internal val md_theme_light_onError = Color(0xFFFFFFFF)
internal val md_theme_light_onErrorContainer = Color(0xFF410002)
internal val md_theme_light_background = Color(0xFFFFFFBFF)
internal val md_theme_light_onBackground = Color(0xFFAF9FF)
internal val md_theme_light_surface = Color(0xFFFFFBFF)
internal val md_theme_light_onSurface = Color(0xFF221B00)
internal val md_theme_light_surfaceVariant = Color(0xFFDBE4E7)
internal val md_theme_light_onSurfaceVariant = Color(0xFF3F484B)
internal val md_theme_light_outline = Color(0xFF70797B)
internal val md_theme_light_inverseOnSurface = Color(0xFFFFF0C0)
internal val md_theme_light_inverseSurface = Color(0xFF3A3000)
internal val md_theme_light_inversePrimary = Color(0xFF55D6F4)
internal val md_theme_light_shadow = Color(0xFF000000)
internal val md_theme_light_surfaceTint = Color(0xFF00687A)
internal val md_theme_light_outlineVariant = Color(0xFFBFC8CB)
internal val md_theme_light_scrim = Color(0xFF000000)

internal val md_theme_dark_primary = Color(0xF1483FF)
internal val md_theme_dark_onPrimary = Color(0xFFFFFFFF)
internal val md_theme_dark_primaryContainer = Color(0xFF2F2F2F)
internal val md_theme_dark_onPrimaryContainer = Color(0xF191919)
internal val md_theme_dark_secondary = Color(0x33ffffff)
internal val md_theme_dark_onSecondary = Color(0xFF00373A)
internal val md_theme_dark_secondaryContainer = Color(0xFF004F53)
internal val md_theme_dark_onSecondaryContainer = Color(0xFF6FF6FE)
internal val md_theme_dark_tertiary = Color(0xFFFFB77C)
internal val md_theme_dark_onTertiary = Color(0xFF4D2700)
internal val md_theme_dark_tertiaryContainer = Color(0xFF6D3900)
internal val md_theme_dark_onTertiaryContainer = Color(0xFFFFDCC2)
internal val md_theme_dark_error = Color(0xFFFFB4AB)
internal val md_theme_dark_errorContainer = Color(0xFF93000A)
internal val md_theme_dark_onError = Color(0xFF690005)
internal val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
internal val md_theme_dark_background = Color(0xFF221B00)
internal val md_theme_dark_onBackground = Color(0xF0A0A0A)
internal val md_theme_dark_surface = Color(0xFF221B00)
internal val md_theme_dark_onSurface = Color(0xFFFFE264)
internal val md_theme_dark_surfaceVariant = Color(0xFF3F484B)
internal val md_theme_dark_onSurfaceVariant = Color(0xFFBFC8CB)
internal val md_theme_dark_outline = Color(0xFF899295)
internal val md_theme_dark_inverseOnSurface = Color(0xFF221B00)
internal val md_theme_dark_inverseSurface = Color(0xFFFFE264)
internal val md_theme_dark_inversePrimary = Color(0xFF00687A)
internal val md_theme_dark_shadow = Color(0xFF000000)
internal val md_theme_dark_surfaceTint = Color(0xFF55D6F4)
internal val md_theme_dark_outlineVariant = Color(0xFF3F484B)
internal val md_theme_dark_scrim = Color(0xFF000000)


internal val seed = Color(0xFF2C3639)

interface OilPayColors {
    val primary: Color
    val primaryContainer: Color
    val tertiary: Color
    val background: Color
    val onBackground: Color
    val secondary: Color
    val onSecondary: Color
    val onPrimary: Color
}

class OilPayColorsLight(
    override val primary: Color,
    override val primaryContainer: Color,
    override val tertiary: Color,
    override val background: Color,
    override val onBackground: Color,
    override val secondary: Color,
    override val onSecondary: Color,
    override val onPrimary: Color,
) : OilPayColors


internal val LocalColors = compositionLocalOf<OilPayColors> {
    error(
        "No colors provided! Make sure to wrap all usages of components in a " +
                "TalkTheme."
    )
}


fun lightColors(): OilPayColors {
    return OilPayColorsLight(
        primary = md_theme_light_primary,
        primaryContainer = md_theme_light_primaryContainer,
        tertiary = md_theme_light_tertiary,
        background = Color.White,
        onBackground = Color.Black,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        onPrimary = md_theme_light_onPrimary,
    )
}


fun darkColors(): OilPayColors {
    return OilPayColorsLight(
        primary = md_theme_light_primary,
        primaryContainer = md_theme_dark_primaryContainer,
        tertiary = md_theme_dark_tertiary,
        background = Color.Black,
        onBackground = Color.White,
        secondary = md_theme_dark_secondary,
        onSecondary = md_theme_dark_onSecondary,
        onPrimary = md_theme_light_onPrimary
    )
}

