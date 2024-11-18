package com.oilpay.feature.pin_code.domain.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.feature.pin_code.PinCodeComponent
import com.oilpay.feature.pin_code.ui.PinCodeScreen
import kotlinx.coroutines.flow.Flow
import libraries.decompose.common.MviComponent
import libraries.decompose.common.MviStore
import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl

class PinCodeComponentImpl(
    appComponentContext: AppComponentContext,
):
    PinCodeComponent,
    AppComponentContext by appComponentContext,
    MviComponent<PinCodeState, PinCodeAction, PinCodeSideEffect, PinCodeStore>,
    EventsProducerDelegate<PinCodeComponent.Event> by EventsProducerDelegateImpl()
{
    override val content: ComponentContent = PinCodeScreen(this)

    override val store: PinCodeStore = instanceKeeper.getOrCreate { PinCodeStore() }

    override fun dispatchAction(action: PinCodeAction) {

    }
}