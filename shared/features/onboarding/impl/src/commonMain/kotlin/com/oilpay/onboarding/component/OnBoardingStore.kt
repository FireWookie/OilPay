package com.oilpay.onboarding.component

import libraries.decompose.common.MviStore

data class OnBoardingState(
    val page: Int = 1
)

sealed interface OnBoardingAction {
    data object Skip: OnBoardingAction
    data object NextPage: OnBoardingAction
    data object NavigateToAuth: OnBoardingAction
    data object PreviousPage: OnBoardingAction
}

sealed interface OnBoardingSideEffect {

}

class OnBoardingStore: MviStore<OnBoardingState, OnBoardingAction, OnBoardingSideEffect>(
    state = OnBoardingState()
),  OnBoardingInteractor by OnBoardingInteractorImpl()