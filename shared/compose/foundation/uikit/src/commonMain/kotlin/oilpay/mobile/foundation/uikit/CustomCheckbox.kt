package oilpay.mobile.foundation.uikit

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import oilpay.mobile.foundation.uikit.modifiers.noIndicationClickable


@Composable
fun CustomCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier
            .noIndicationClickable { onCheckedChange.invoke(checked) }
            .then(modifier)
    ) {
        Checkbox(checked)
        CustomSpacer(15.dp)
        content.invoke()
    }
}

@Composable
private fun Checkbox(
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    val float = if (selected) 1f else 0f
    val color = if (selected) Color(0xffFF7C1A) else Color(0xff6A6A6A)
    val animatedColor by animateColorAsState(color)
    val animatedFloat by animateFloatAsState(float)
    Box(
        modifier = Modifier
            .size(24.dp)
            .border(2.dp, animatedColor)
            .then(modifier)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = Color(0xffFF7C1A),
            modifier = Modifier.scale(animatedFloat)
        )

    }
}