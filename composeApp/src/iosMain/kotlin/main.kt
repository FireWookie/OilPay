import androidx.compose.ui.window.ComposeUIViewController
import com.oilpay.mobile.App
import com.oilpay.mobile.features.root.domain.RootComponent
import com.oilpay.mobile.features.root.screen.RootScreen
import platform.UIKit.UIViewController

fun MainViewController(rootComponent: RootComponent): UIViewController =
    ComposeUIViewController { RootScreen(rootComponent) }
