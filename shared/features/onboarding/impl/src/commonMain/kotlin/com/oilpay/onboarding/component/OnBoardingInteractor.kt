package com.oilpay.onboarding.component

import com.oilpay.core.storage.OnBoardingStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface OnBoardingInteractor {
    suspend fun setViewedOnBoarding(isViewed: Boolean = ON_BOARDING_VIEWED)

    companion object {
        private const val ON_BOARDING_VIEWED = true
    }
}

internal class OnBoardingInteractorImpl: OnBoardingInteractor, KoinComponent {
    private val storage: OnBoardingStorage by inject()

    override suspend fun setViewedOnBoarding(isViewed: Boolean) {
        storage.setOnBoardingStatus(isViewed)
    }
}