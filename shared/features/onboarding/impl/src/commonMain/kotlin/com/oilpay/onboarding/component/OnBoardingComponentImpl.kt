package com.oilpay.onboarding.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.onboarding.OnBoardingComponent
import com.oilpay.onboarding.ui.OnBoardingScreen
import libraries.decompose.common.MviComponent
import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl

internal class OnBoardingComponentImpl(
    private val appComponentContext: AppComponentContext
):  OnBoardingComponent,
    MviComponent<OnBoardingState, OnBoardingAction, OnBoardingSideEffect, OnBoardingStore>,
    AppComponentContext by appComponentContext,
    EventsProducerDelegate<OnBoardingComponent.Event> by EventsProducerDelegateImpl() {

    override val content: ComponentContent = OnBoardingScreen(this)

    override val store: OnBoardingStore = instanceKeeper.getOrCreate { OnBoardingStore() }

    override fun dispatchAction(action: OnBoardingAction) {
        when(action) {
            OnBoardingAction.NextPage -> intent { reduce { state.copy(page = state.page + 1) } }
            OnBoardingAction.PreviousPage -> intent { reduce { state.copy(page = state.page - 1) } }
            OnBoardingAction.Skip -> skipOnBoarding()
            OnBoardingAction.NavigateToAuth -> dispatch(OnBoardingComponent.Event.NavigateToAuth)
        }
    }

    private fun skipOnBoarding() {
        store.launch {
            store.setViewedOnBoarding()
        }
        dispatch(OnBoardingComponent.Event.NavigateToAuth)
    }

}