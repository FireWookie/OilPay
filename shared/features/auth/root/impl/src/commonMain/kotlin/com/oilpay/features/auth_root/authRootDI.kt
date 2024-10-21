package com.oilpay.features.auth_root

import com.oilpay.features.auth_root.component.AuthRootComponentImpl
import org.koin.dsl.module

val authRootDI = module {
    single {
        AuthRootScreenComponent.Factory { context, onNavigate ->
            AuthRootComponentImpl(
                componentContext = context,
                onNavigateMain = onNavigate
            )
        }
    }
}