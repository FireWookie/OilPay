package com.oilpay.features.otp_code.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oilpay.features.otp_code.component.OtpCodeAction
import com.oilpay.features.otp_code.component.OtpCodeComponentImpl
import com.oilpay.features.otp_code.component.OtpCodeState
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.mobile.compose.resources.again_send_code
import com.oilpay.mobile.compose.resources.and
import com.oilpay.mobile.compose.resources.call_operator
import com.oilpay.mobile.compose.resources.code_have_been_send_to
import com.oilpay.mobile.compose.resources.confirm
import com.oilpay.mobile.compose.resources.enter
import com.oilpay.mobile.compose.resources.new_code_after
import com.oilpay.mobile.compose.resources.sms_code
import com.oilpay.mobile.foundation.core.CenteredColumn
import libraries.decompose.common.content.ComponentContent
import oilpay.mobile.foundation.theme.OilPayTheme
import oilpay.mobile.foundation.uikit.CustomSpacer
import oilpay.mobile.foundation.uikit.WeightSpacer
import oilpay.mobile.foundation.uikit.buttons.PrimaryButton
import oilpay.mobile.foundation.uikit.input.CodeField
import oilpay.mobile.foundation.uikit.input.CodeStatus
import oilpay.mobile.foundation.uikit.text.TextLink
import oilpay.mobile.foundation.uikit.text.TwoColorText
import org.jetbrains.compose.resources.stringResource

internal class OtpCodeScreen(
    private val component: OtpCodeComponentImpl
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()

        OtpContent(
            state = state,
        )
    }

    @Composable
    private fun OtpContent(
        state: OtpCodeState
    ) {
        CenteredColumn(
            horizontal = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(OilPayTheme.colors.background)
                .padding(horizontal = 20.dp)
                .navigationBarsPadding()
                .padding(bottom = 20.dp)
                .imePadding(),
        ) {
            WeightSpacer()
            TwoColorText(
                defaultText = stringResource(Res.string.enter),
                accentText = stringResource(Res.string.sms_code)
            )
            Text(
                text = stringResource(Res.string.code_have_been_send_to, state.phone),
                style = OilPayTheme.typography.mediumLabel,
                textAlign = TextAlign.Center
            )
            CustomSpacer(40.dp)
            CodeField(
                value = state.otp,
                onValueChange = { code ->
                    component.dispatchAction(OtpCodeAction.InputCode(code))
                },
                length = 5,
                status = CodeStatus.Correct
            )
            CustomSpacer(25.dp)

            Crossfade(state.isTimerEnd) { isExpired ->
                if (isExpired) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextLink(
                            text = stringResource(Res.string.again_send_code)
                        ) {
                            component.dispatchAction(OtpCodeAction.ResendCode)
                        }
                        Text(
                            text = stringResource(Res.string.and),
                            fontSize = 12.sp
                        )
                        TextLink(
                            text = stringResource(Res.string.call_operator)
                        ) {
                            component.dispatchAction(OtpCodeAction.CallOperator)
                        }
                    }
                } else {
                    Row {
                        val time = when {
                            (state.timer >= 60) -> "1:00"
                            (state.timer < 10) -> "0:0${state.timer}"
                            else -> "0:${state.timer}"
                        }
                        Text(
                            text = stringResource(Res.string.new_code_after),
                            fontSize = 12.sp
                        )
                        TextLink(
                            text = time,
                            fontWeight = 600
                        ) {
                           component.dispatchAction(OtpCodeAction.ResendCode)
                        }
                    }
                }
            }
            WeightSpacer()

            PrimaryButton(
                text = stringResource(Res.string.confirm),
                isEnabled = !state.isLoading && state.otp.length == 5,
                onClick = {
                    component.dispatchAction(OtpCodeAction.ClickConfirm)
                }
            )
        }
    }

}