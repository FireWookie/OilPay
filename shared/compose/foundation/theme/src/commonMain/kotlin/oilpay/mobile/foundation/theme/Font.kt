package oilpay.mobile.foundation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.oilpay.mobile.compose.resources.Res

class MemoFonts(
    val regular: TextStyle,
    val medium: TextStyle,
    val bold: TextStyle
)

@Composable
fun MemoFont(): MemoFonts {

    val regular = TextStyle(
        fontFamily = memoFontFamily(),
        fontWeight = FontWeight.Normal
    )
    val medium = TextStyle(
        fontFamily = memoFontFamily(),
        fontWeight = FontWeight.Medium
    )
    val bold = TextStyle(
        fontFamily = memoFontFamily(),
        fontWeight = FontWeight.Bold
    )

    return MemoFonts(
        regular = regular,
        medium = medium,
        bold = bold
    )
}

@Composable
fun memoFontFamily(): FontFamily {

    val fontFamily = FontFamily(
//        Font(Res.font.NTSomic_Regular),
//        Font(Res.font.NTSomic_Medium),
//        Font(Res.font.NTSomic_Bold)
    )

    return fontFamily
}