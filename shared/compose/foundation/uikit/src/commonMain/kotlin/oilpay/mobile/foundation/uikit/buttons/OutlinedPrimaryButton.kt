package oilpay.mobile.foundation.uikit.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedPrimaryButton(
    text: String,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        enabled = isEnabled,
        shape = RoundedCornerShape(2.dp),
        border = BorderStroke(1.dp, Color(0xFF0079E0)),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Unspecified,
            contentColor = Color(0xFF0079E0),
            disabledContentColor = Color(0xFF6A6A6A),
            disabledContainerColor = Color(0xFF393939)
        ),
        modifier = Modifier.fillMaxWidth().height(40.dp).then(modifier)
    ) { Text(text) }
}