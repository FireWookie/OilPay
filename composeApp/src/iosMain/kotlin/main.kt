import androidx.compose.ui.window.ComposeUIViewController
import com.oilpay.mobile.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
