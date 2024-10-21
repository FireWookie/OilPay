package com.oilpay.onboarding.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import com.oilpay.mobile.compose.resources.Res
import com.oilpay.onboarding.component.OnBoardingComponentImpl
import libraries.decompose.common.content.ComponentContent
import org.jetbrains.compose.resources.imageResource

internal class OnBoardingScreen(
    private val component: OnBoardingComponentImpl
): ComponentContent {

    @Composable
    override fun Content(modifier: Modifier) {
        val state by component.store.container.stateFlow.collectAsState()

    }

    @Composable
    private fun pagerImage(page: Int): ImageBitmap {
        return when(page + 1) {
            1 -> imageResource(Res.drawable)
            2 -> imageResource(Res.drawable)
            3 -> imageResource(Res.drawable)
            4 -> imageResource(Res.drawable)
            5 -> imageResource(Res.drawable)
            else -> imageResource(Res.drawable)
        }
    }
}