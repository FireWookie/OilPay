package com.oilpay.features.otp_code

import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducer

interface OtpCodeScreenComponent:
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<OtpCodeScreenComponent.Event> {

    fun interface Factory {

        fun create(
            context: AppComponentContext
        ): OtpCodeScreenComponent
    }

    sealed class Event {
        data object GoVerification : Event()
    }
}