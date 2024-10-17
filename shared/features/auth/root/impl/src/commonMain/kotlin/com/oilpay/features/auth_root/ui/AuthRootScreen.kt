package com.oilpay.features.auth_root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.oilpay.features.auth_root.component.AuthRootComponent
import com.oilpay.mobile.login.api.LoginComponent
import libraries.decompose.common.content.ComponentContent


internal class AuthRootScreen(
    private val component: AuthRootComponent
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        LaunchedEffect(Unit) {
            println("In root auth")
        }
        Children(
            stack = component.childStack
        ) { child ->
            println("Stack root: ${child.instance}")
            when (val instance = child.instance) {
                is LoginComponent -> instance.content.Content(modifier)
            }
        }
    }

}