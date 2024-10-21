package oilpay.mobile.foundation.uikit.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import oilpay.mobile.foundation.theme.OilPayTheme
import oilpay.mobile.foundation.theme.TrapezoidShape

@Composable
fun TrapezoidRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth()
            .heightIn(137.dp)
            .background(OilPayTheme.colors.secondary, shape = TrapezoidShape())
            .padding(horizontal = 20.dp, vertical = 25.dp)
            .then(modifier),
        content = content
    )
}