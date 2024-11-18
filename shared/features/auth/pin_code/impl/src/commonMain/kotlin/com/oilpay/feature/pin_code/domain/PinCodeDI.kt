package com.oilpay.feature.pin_code.domain

import com.oilpay.feature.pin_code.PinCodeComponent
import com.oilpay.feature.pin_code.domain.component.PinCodeComponentImpl
import org.koin.dsl.module

val pinCodeModuleDI = module {
    single {
        PinCodeComponent.Factory { context ->
            PinCodeComponentImpl(context)
        }
    }
}