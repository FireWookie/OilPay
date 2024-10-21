package oilpay.mobile.foundation.uikit.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import oilpay.mobile.foundation.uikit.modifiers.noIndicationClickable

@Composable
fun TextLink(
    text: String,
    fontSize: TextUnit = 10.sp,
    fontWeight: Int = 500,
    textDecoration: TextDecoration = TextDecoration.None,
    onClick: () -> Unit
) {
    Text(
        text,
        fontSize = fontSize,
        fontWeight = FontWeight(fontWeight),
        color = Color(0xff0079E0),
        textDecoration = textDecoration,
        modifier = Modifier.noIndicationClickable(onClick)
    )
}