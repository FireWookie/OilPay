package com.oilpay.features.auth_root.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.oilpay.features.auth_root.domain.component.AuthRootComponent
import com.oilpay.mobile.login.api.LoginComponent

@Composable
fun AuthRootScreen(component: AuthRootComponent) {
    Children(
        stack = component.childStack
    ) { child ->
        when (val instance = child.instance) {
            is LoginComponent -> instance.content.Content(modifier = Modifier)
        }
    }
}