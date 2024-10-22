package oilpay.mobile.foundation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

class OilPayTypographies(
    val smallLabel: TextStyle,
    val mediumLabel: TextStyle,
    val smallTitle: TextStyle,
    val mediumTitle: TextStyle,
    val mediumDisplay: TextStyle,
)

@Composable
fun OilPayTypography() = OilPayTypographies(
    smallLabel = smallLabel(),
    mediumLabel = mediumLabel(),
    smallTitle = smallTitle(),
    mediumTitle = mediumTitle(),
    mediumDisplay = mediumDisplay()
)

@Composable
private fun smallLabel() = TextStyle(
    fontSize = 10.sp,
    fontWeight = regularW,
    lineHeight = 12.sp,
    color = OilPayTheme.colors.text,
    fontFamily = OilPayTheme.fonts.montserrat
)

@Composable
private fun mediumLabel() = TextStyle(
    fontSize = 12.sp,
    fontWeight = regularW,
    lineHeight = 14.sp,
    color = OilPayTheme.colors.onBackground,
    fontFamily = OilPayTheme.fonts.montserrat
)

@Composable
private fun smallTitle() = TextStyle(
    fontSize = 12.sp,
    fontWeight = boldW,
    lineHeight = 14.sp,
    color = OilPayTheme.colors.onBackground,
    fontFamily = OilPayTheme.fonts.montserrat
)

@Composable
private fun mediumTitle() = TextStyle(
    fontSize = 14.sp,
    fontWeight = boldW,
    lineHeight = 17.sp,
    color = OilPayTheme.colors.onBackground,
    fontFamily = OilPayTheme.fonts.montserrat
)

@Composable
private fun mediumDisplay() = TextStyle(
    fontSize = 20.sp,
    fontWeight = blackW,
    lineHeight = 24.sp,
    color = OilPayTheme.colors.onBackground,
    fontFamily = OilPayTheme.fonts.montserrat
)

