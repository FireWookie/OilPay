package oilpay.mobile.foundation.uikit.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import oilpay.mobile.foundation.theme.OilPayTheme

@Composable
fun IconBackButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(24.dp).then(modifier)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = OilPayTheme.colors.onBackground
        )
    }
}