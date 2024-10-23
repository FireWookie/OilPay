package com.oilpay.features.otp_code

import com.oilpay.features.otp_code.component.OtpCodeComponentImpl
import org.koin.dsl.module

val otpCodeModuleDI = module {
    single {
        OtpCodeScreenComponent.Factory { context, phone ->
            OtpCodeComponentImpl(context, phone)
        }
    }
}