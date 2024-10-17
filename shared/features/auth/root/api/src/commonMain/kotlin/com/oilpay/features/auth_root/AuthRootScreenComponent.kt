package com.oilpay.features.auth_root

import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducer

interface AuthRootScreenComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<AuthRootScreenComponent.Event> {

    fun interface Factory {

        fun create(context: AppComponentContext): AuthRootScreenComponent
    }

    sealed class Event {

        data object OnBackClick : Event()
    }
}