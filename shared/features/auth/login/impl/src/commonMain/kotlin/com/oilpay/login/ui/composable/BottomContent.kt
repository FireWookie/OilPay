package com.oilpay.login.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.`continue`
import com.oilpay.mobile.compose.resources.i_accept
import com.oilpay.mobile.compose.resources.offer_link
import com.oilpay.mobile.compose.resources.public_offerts
import oilpay.mobile.foundation.uikit.CustomCheckbox
import oilpay.mobile.foundation.uikit.CustomSpacer
import oilpay.mobile.foundation.uikit.buttons.PrimaryButton
import oilpay.mobile.foundation.uikit.text.TextLink
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun BottomContent(
    modifier: Modifier = Modifier,
    isNotEmpty: Boolean,
    checked: Boolean,
    onChangeChecked: (Boolean) -> Unit,
    onClick: () -> Unit
) {
    val uriHandler = LocalUriHandler.current // TODO check work on IOS
    val uri = stringResource(Res.string.offer_link) // TODO replace link
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomCheckbox(
                checked = checked,
                onCheckedChange = { onChangeChecked.invoke(!it) }
            ) {
                Text(
                    text = stringResource(Res.string.i_accept),
                    fontSize = 10.sp
                )
                TextLink(
                    text = stringResource(Res.string.public_offerts),
                    fontWeight = 400,
                    textDecoration = TextDecoration.Underline
                ) {
                    uriHandler.openUri(uri)
                }
            }
        }
        CustomSpacer(15.dp)
        PrimaryButton(
            text = stringResource(Res.string.`continue`),
            isEnabled = (checked && isNotEmpty)
        ) {
            onClick.invoke()
        }
    }
}