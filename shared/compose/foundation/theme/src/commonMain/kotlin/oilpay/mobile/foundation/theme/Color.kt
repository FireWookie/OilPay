package oilpay.mobile.foundation.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

// TODO change light colors scheme
internal val md_theme_light_onPrimary = Color(0xFFFFFFFF)
internal val md_theme_light_primaryContainer = Color(0xF000000)
internal val md_theme_light_secondary = Color(0xFF232222)
internal val md_theme_light_onSecondary = Color(0xFFE1E0E6)
internal val md_theme_light_tertiary = Color(0xFFFFFFFF)

// TODO change dark colors scheme
internal val md_theme_dark_primaryContainer = Color(0xFF2F2F2F)
internal val md_theme_dark_secondary = Color(0x33ffffff)
internal val md_theme_dark_onSecondary = Color(0xFF00373A)
internal val md_theme_dark_tertiary = Color(0xFFFFB77C)


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
        primary = Color(0xFFFF7C1A),
        primaryContainer = md_theme_light_primaryContainer,
        tertiary = md_theme_light_tertiary,
        background = Color.White,
        onBackground = Color.Black,
        secondary = Color(0xFF232222),
        onSecondary = md_theme_light_onSecondary,
        onPrimary = md_theme_light_onPrimary,
    )
}


fun darkColors(): OilPayColors {
    return OilPayColorsLight(
        primary = Color(0xFFFF7C1A),
        primaryContainer = md_theme_dark_primaryContainer,
        tertiary = md_theme_dark_tertiary,
        background = Color.Black,
        onBackground = Color.White,
        secondary = Color(0xFF232222),
        onSecondary = md_theme_dark_onSecondary,
        onPrimary = md_theme_light_onPrimary
    )
}

