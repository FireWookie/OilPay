package com.oilpay.login

import com.oilpay.login.component.LoginComponentImpl
import com.oilpay.mobile.login.api.LoginComponent
import org.koin.dsl.module

val loginModuleDI = module {
    single {
        LoginComponent.Factory { context ->
            LoginComponentImpl(
                context = context
            )
        }
    }
}