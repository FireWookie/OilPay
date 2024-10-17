package com.oilpay.features.auth_root

import com.oilpay.features.auth_root.component.AuthRootComponent
import com.oilpay.features.auth_root.component.AuthRootComponentImpl
import com.oilpay.mobile.login.api.LoginComponent
import org.koin.dsl.module

val authRootDI = module {
    single {
        AuthRootScreenComponent.Factory { context ->
            AuthRootComponentImpl(
                componentContext = context
            )
        }
    }
}