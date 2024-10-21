package com.oilpay.mobile.features.root.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.oilpay.features.auth_root.AuthRootScreenComponent
import com.oilpay.mobile.features.root.domain.RootComponent
import libraries.decompose.common.content.ComponentContentOwner

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.childStack
    ) { stack ->
        println("Stack: ${stack.instance}")
        when(val instance = stack.instance) {
            is ComponentContentOwner -> instance.content.Content(Modifier)
        }
    }
}