package com.oilpay.features.auth_root

import com.oilpay.features.auth_root.component.AuthRootComponentImpl
import org.koin.dsl.module

val authRootModuleDI = module {
    single {
        AuthRootScreenComponent.Factory { context ->
            AuthRootComponentImpl(
                componentContext = context
            )
        }
    }
}