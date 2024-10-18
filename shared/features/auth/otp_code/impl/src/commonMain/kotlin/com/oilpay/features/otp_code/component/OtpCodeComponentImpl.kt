package com.oilpay.features.otp_code.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.features.otp_code.OtpCodeScreenComponent
import com.oilpay.features.otp_code.ui.OtpCodeScreen
import libraries.decompose.common.MviComponent
import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl

class OtpCodeComponentImpl(
    context: AppComponentContext
): MviComponent<OtpCodeState, OtpCodeAction, OtpCodeSideEffect, OtpCodeStore>,
    OtpCodeScreenComponent,
    EventsProducerDelegate<OtpCodeScreenComponent.Event> by EventsProducerDelegateImpl(),
    AppComponentContext by context {

    override val content: ComponentContent = OtpCodeScreen(this)

    override val store: OtpCodeStore = instanceKeeper.getOrCreate { OtpCodeStore() }

    override fun dispatchAction(action: OtpCodeAction) {
        when (action) {
            OtpCodeAction.ClickConfirm -> {}
            is OtpCodeAction.InputCode -> {}
        }
    }
}