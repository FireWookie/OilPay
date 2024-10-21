package com.oilpay.onboarding.component

import org.koin.core.component.KoinComponent

interface OnBoardingInteractor {
    suspend fun setViewedOnBoarding()
}

internal class OnBoardingInteractorImpl: OnBoardingInteractor, KoinComponent {

    override suspend fun setViewedOnBoarding() {

    }

}