package com.oilpay.feature.pin_code

import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducer

interface PinCodeComponent:
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<PinCodeComponent.Event> {

    fun interface Factory {

        fun create(context: AppComponentContext): PinCodeComponent
    }

    sealed class Event {
        data class NavigateToOtp(val phone: String) : Event()
    }
}