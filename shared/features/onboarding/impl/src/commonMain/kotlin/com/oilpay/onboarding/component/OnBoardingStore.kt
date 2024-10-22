package com.oilpay.onboarding.component

import libraries.decompose.common.MviStore

data class OnBoardingState(
    val page: Int = 1
)

sealed interface OnBoardingAction {
    data object Skip: OnBoardingAction
    data object NavigateToAuth: OnBoardingAction
    data class ChangePage(val page: Int): OnBoardingAction
}

sealed interface OnBoardingSideEffect {

}

class OnBoardingStore: MviStore<OnBoardingState, OnBoardingAction, OnBoardingSideEffect>(
    state = OnBoardingState()
),  OnBoardingInteractor by OnBoardingInteractorImpl()