package com.oilpay.features.splash.component

import libraries.decompose.common.MviStore

data class SplashState(
    val isLoading: Boolean = false
)

sealed interface SplashAction {

}

sealed interface OnBoardingSideEffect {

}

class SplashStore: MviStore<SplashState, SplashAction, OnBoardingSideEffect>(
    state = SplashState()
),  SplashInteractor by SplashInteractorImpl()