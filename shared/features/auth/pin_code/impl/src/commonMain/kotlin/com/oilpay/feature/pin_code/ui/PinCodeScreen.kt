package com.oilpay.feature.pin_code.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.oilpay.feature.pin_code.domain.component.PinCodeComponentImpl
import libraries.decompose.common.content.ComponentContent

class PinCodeScreen(
    private val component: PinCodeComponentImpl
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()
    }
}