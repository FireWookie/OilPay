package com.oilpay.mobile

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.oilpay.mobile.features.root.domain.RootComponent
import com.oilpay.mobile.features.root.domain.buildRootComponent
import com.oilpay.mobile.features.root.screen.RootScreen
import oilpay.mobile.foundation.theme.OilPayTheme

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.dark(
                Color.TRANSPARENT
            )
        )
        val root = buildRootComponent(defaultComponentContext())
        setContent {

            OilPayTheme {
                RootScreen(component = root)
            }
        }
    }
}
