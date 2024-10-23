package com.oilpay.features.otp_code.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.features.otp_code.OtpCodeScreenComponent
import com.oilpay.features.otp_code.ui.OtpCodeScreen
import kotlinx.coroutines.delay
import libraries.decompose.common.MviComponent
import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl

class OtpCodeComponentImpl(
    context: AppComponentContext,
    private val phone: String
): MviComponent<OtpCodeState, OtpCodeAction, OtpCodeSideEffect, OtpCodeStore>,
    OtpCodeScreenComponent,
    EventsProducerDelegate<OtpCodeScreenComponent.Event> by EventsProducerDelegateImpl(),
    AppComponentContext by context {

    override val content: ComponentContent = OtpCodeScreen(this)

    override val store: OtpCodeStore = instanceKeeper.getOrCreate { OtpCodeStore() }

    override fun dispatchAction(action: OtpCodeAction) {
        when (action) {
            OtpCodeAction.ClickConfirm -> validateCode()
            is OtpCodeAction.InputCode -> editCode(action.otp)
            OtpCodeAction.CallOperator -> callOperator()
            OtpCodeAction.ResendCode -> resendCode()
        }
    }

    init {
        insertPhone()
        launchTimer()
    }

    private fun callOperator() {

    }

    private fun resendCode() {

    }

    private fun editCode(code: String) = blockingIntent {
        reduce { state.copy(otp = code) }
    }

    private fun insertPhone() = blockingIntent {
        reduce { state.copy(phone = phone) }
    }

    private fun launchTimer() = store.launch {
        intent {
            reduce { state.copy(timer = 60) }
            repeat(state.timer) {
                delay(1000)
                reduce {
                    state.copy(
                        timer = state.timer - 1,
                        isTimerEnd = state.timer == 1
                    )
                }
            }
        }

    }

    private fun validateCode() {

    }
}