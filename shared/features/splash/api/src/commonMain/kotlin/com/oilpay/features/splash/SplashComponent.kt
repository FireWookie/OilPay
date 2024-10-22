package com.oilpay.features.splash

import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducer

interface SplashComponent:
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<SplashComponent.Event> {

    fun interface Factory {
        fun create(context: AppComponentContext): SplashComponent
    }

    sealed class Event {
        data object NavigateToAuth: Event()
        data object NavigateToMain: Event()
        data object NavigateToOnBoarding: Event()
    }
}