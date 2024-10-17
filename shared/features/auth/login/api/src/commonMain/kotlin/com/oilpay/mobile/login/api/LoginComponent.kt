package com.oilpay.mobile.login.api

import com.arkivanov.decompose.ComponentContext
import libraries.decompose.common.DecomposeComponent
import libraries.decompose.common.ScreenDecomposeComponent
import libraries.decompose.common.content.ComponentContentOwner

interface LoginScreenComponent: ComponentContentOwner {
    fun interface Factory {
        fun create(
            context: ComponentContext,
            onBack: () -> Unit
        ): LoginScreenComponent
    }

    fun onBackClick()
}