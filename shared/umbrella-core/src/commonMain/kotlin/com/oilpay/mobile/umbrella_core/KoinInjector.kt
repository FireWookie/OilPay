package com.oilpay.mobile.umbrella_core

import com.oilpay.core.storage.storageModule
import com.oilpay.features.auth_root.authRootModuleDI
import com.oilpay.features.otp_code.otpCodeModuleDI
import com.oilpay.features.splash.splashModuleDI
import com.oilpay.login.loginModuleDI
import com.oilpay.mobile.network.networkModule
import com.oilpay.onboarding.onBoardingModuleDI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

private val coroutineModule = module {
    single { CoroutineScope(SupervisorJob() + Dispatchers.Main) }
}

object KoinInjector {

    val koinApp = startKoin {
        modules(
            listOf(
                sharedModule,
                storageModule,
                coroutineModule,
                networkModule,
                loginModuleDI,
                authRootModuleDI,
                onBoardingModuleDI,
                splashModuleDI,
                otpCodeModuleDI
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}