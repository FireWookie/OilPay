package com.oilpay.features.splash.component

import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.oilpay.features.splash.SplashComponent
import com.oilpay.features.splash.ui.SplashScreen
import kotlinx.coroutines.delay
import libraries.decompose.common.MviComponent
import libraries.decompose.common.content.ComponentContent
import libraries.decompose.common.context.AppComponentContext
import libraries.decompose.common.producer.EventsProducerDelegate
import libraries.decompose.common.producer.EventsProducerDelegateImpl

internal class SplashComponentImpl(
    private val appComponentContext: AppComponentContext,
):  SplashComponent,
    MviComponent<SplashState, SplashAction, OnBoardingSideEffect, SplashStore>,
    AppComponentContext by appComponentContext,
    EventsProducerDelegate<SplashComponent.Event> by EventsProducerDelegateImpl() {

    override val content: ComponentContent = SplashScreen(this)
    override val store: SplashStore = instanceKeeper.getOrCreate { SplashStore() }

    init {
        checkNavigation()
    }

    override fun dispatchAction(action: SplashAction) {

    }

    private fun checkNavigation() = store.launch {
        val isAuth = store.isAuthUser()
        val isViewOnBoarding = store.onBoardingInfoViewed()
        delay(2000)
        if (isAuth && isViewOnBoarding) {
            dispatch(SplashComponent.Event.NavigateToMain)
        } else if (!isAuth && !isViewOnBoarding) {
            dispatch(SplashComponent.Event.NavigateToOnBoarding)
        } else {
            dispatch(SplashComponent.Event.NavigateToOnBoarding)
        }
    }
}