package com.oilpay.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oilpay.login.component.LoginComponentImpl
import libraries.decompose.common.content.ComponentContent

internal class LoginScreen(
    private val component: LoginComponentImpl
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.White)
        ) {
            Text(
                text = "Login",
                modifier = Modifier.clickable {

                }
            )
        }
    }

}