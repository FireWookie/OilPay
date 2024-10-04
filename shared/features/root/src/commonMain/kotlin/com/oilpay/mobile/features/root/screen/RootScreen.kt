package com.oilpay.mobile.features.root.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.oilpay.mobile.features.root.domain.RootComponent

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.childStack
    ) { stack ->
        when(stack.instance) {
            is RootComponent.Child.Auth -> TODO()
            is RootComponent.Child.OnBoarding -> TODO()
        }
    }
}