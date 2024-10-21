package com.oilpay.onboarding

import com.arkivanov.decompose.router.stack.ChildStack
import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducer

interface OnBoardingComponent :
    DecomposeComponent,
    ComponentContentOwner,
    EventsProducer<OnBoardingComponent.Event> {

    fun interface Factory {

        fun create(context: AppComponentContext): OnBoardingComponent
    }

    sealed class Event {
        data object NavigateToAuth: Event()
    }
}