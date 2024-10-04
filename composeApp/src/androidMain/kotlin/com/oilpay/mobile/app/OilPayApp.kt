package com.oilpay.mobile.app

import android.app.Application
import com.oilpay.mobile.umbrella_core.KoinInjector
import org.koin.android.ext.koin.androidContext

class OilPayApp: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
    }
}