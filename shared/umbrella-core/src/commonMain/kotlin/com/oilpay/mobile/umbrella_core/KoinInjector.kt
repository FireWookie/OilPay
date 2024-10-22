package com.oilpay.mobile.umbrella_core

import com.oilpay.core.storage.storageModule
import com.oilpay.features.auth_root.authRootDI
import com.oilpay.features.splash.splashModule
import com.oilpay.login.loginModuleDI
import com.oilpay.mobile.network.networkModule
import com.oilpay.onboarding.onBoardingModule
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
                authRootDI,
                onBoardingModule,
                splashModule
            )
        )
    }

    val koin = koinApp.koin

    fun loadModules(modules: List<Module>) {
        koinApp.koin.loadModules(modules)
    }
}