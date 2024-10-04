package oilpay.mobile.foundation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.ViewConfiguration
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun OilPayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides if (darkTheme) darkColors() else lightColors(),
        LocalViewConfiguration provides LocalViewConfiguration.current.updateViewConfiguration()
    ) {
        content()
    }
}

object OilPayTheme {

    val colors: OilPayColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

//    val typography: TalkTypography
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalTypography.current

    val fonts: MemoFonts
        @Composable
        get() = MemoFont()
}

fun ViewConfiguration.updateViewConfiguration() = object : ViewConfiguration {
    override val longPressTimeoutMillis
        get() = this@updateViewConfiguration.longPressTimeoutMillis

    override val doubleTapTimeoutMillis
        get() = this@updateViewConfiguration.doubleTapTimeoutMillis

    override val doubleTapMinTimeMillis
        get() = this@updateViewConfiguration.doubleTapMinTimeMillis

    override val touchSlop: Float
        get() = this@updateViewConfiguration.touchSlop
    override val minimumTouchTargetSize: DpSize
        get() = DpSize(40.dp, 40.dp)
}