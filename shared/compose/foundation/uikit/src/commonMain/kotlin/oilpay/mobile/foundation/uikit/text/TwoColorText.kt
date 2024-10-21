package oilpay.mobile.foundation.uikit.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import oilpay.mobile.foundation.theme.OilPayTheme

@Composable
fun TwoColorText(
    defaultText: String,
    accentText: String,
    fontSize: TextUnit = 20.sp,
    defaultColor: Color = OilPayTheme.colors.onBackground,
    accentColor: Color = OilPayTheme.colors.primary,
    isInverted: Boolean = false,
    modifier: Modifier = Modifier
) {
    val def: Color
    val accent: Color
    val defst: FontStyle
    val accst: FontStyle
    if (isInverted) {
        def = accentColor
        accent = defaultColor
        defst = FontStyle.Italic
        accst = FontStyle.Normal
    } else {
        def = defaultColor
        accent = accentColor
        defst = FontStyle.Normal
        accst = FontStyle.Italic
    }
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = def,
                fontSize = fontSize,
                fontStyle = defst,
                fontWeight = FontWeight(700)
            )
            ) {
                append(defaultText.uppercase())
            }
            append(" ")
            withStyle(style = SpanStyle(
                color = accent,
                fontStyle = accst,
                fontSize = fontSize,
                fontWeight = FontWeight(700)
            )) {
                append(accentText.uppercase())
            }
        },
        modifier = modifier
    )
}