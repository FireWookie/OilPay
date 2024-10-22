package com.oilpay.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
        enableEdgeToEdge()
        val root = buildRootComponent(defaultComponentContext())
        setContent {

            OilPayTheme {
                RootScreen(component = root)
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() { App() }
