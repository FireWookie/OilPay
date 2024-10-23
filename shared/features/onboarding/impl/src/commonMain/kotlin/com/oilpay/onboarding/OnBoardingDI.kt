package com.oilpay.onboarding

import com.oilpay.onboarding.component.OnBoardingComponentImpl
import org.koin.dsl.module

val onBoardingModuleDI = module {
    single {
        OnBoardingComponent.Factory { context ->
            OnBoardingComponentImpl(context)
        }
    }
}