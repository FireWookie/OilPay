import androidx.compose.ui.window.ComposeUIViewController
import com.oilpay.mobile.App
import com.oilpay.mobile.features.root.domain.RootComponent
import com.oilpay.mobile.features.root.screen.RootScreen
import oilpay.mobile.foundation.theme.OilPayTheme
import platform.UIKit.UIViewController

fun MainViewController(rootComponent: RootComponent): UIViewController =
    ComposeUIViewController { OilPayTheme { RootScreen(rootComponent) } }
