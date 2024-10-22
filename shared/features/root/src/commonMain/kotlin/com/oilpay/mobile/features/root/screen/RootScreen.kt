package com.oilpay.mobile.features.root.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.oilpay.features.auth_root.AuthRootScreenComponent
import com.oilpay.mobile.features.root.domain.RootComponent
import libraries.decompose.common.content.ComponentContentOwner

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.childStack,
        animation = stackAnimation { child ->
            when(child.instance) {
                else -> fade() + scale()
            }
        }
    ) { stack ->
        when(val instance = stack.instance) {
            is ComponentContentOwner -> instance.content.Content(Modifier)
        }
    }
}