package com.oilpay.features.splash.component

import com.oilpay.core.storage.AuthStorage
import com.oilpay.core.storage.OnBoardingStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface SplashInteractor {
    fun onBoardingInfoViewed(): Boolean
    fun isAuthUser(): Boolean
}

internal class SplashInteractorImpl: SplashInteractor, KoinComponent {
    private val onBoardingStorage by inject<OnBoardingStorage>()
    private val authStorage by inject<AuthStorage>()

    override fun onBoardingInfoViewed(): Boolean {
        return onBoardingStorage.onBoardingStatus()
    }

    override fun isAuthUser(): Boolean {
        return authStorage.getAccessToken().isNotEmpty()
    }

}