package com.oilpay.mobile.login.api

import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducer

interface LoginComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<LoginComponent.Event> {

    fun interface Factory {

        fun create(context: AppComponentContext): LoginComponent
    }

    sealed class Event {

        data class NavigateToOtp(val phone: String) : Event()
    }
}