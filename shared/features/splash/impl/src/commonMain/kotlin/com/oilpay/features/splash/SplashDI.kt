package com.oilpay.features.splash

import com.oilpay.features.splash.component.SplashComponentImpl
import org.koin.dsl.module

val splashModule = module {
    single {
        SplashComponent.Factory { context ->
            SplashComponentImpl(context)
        }
    }
}