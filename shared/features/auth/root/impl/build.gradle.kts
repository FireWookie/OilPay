import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)
    alias(libs.plugins.kotlinx.serialization)

}

android {
    namespace = "com.oilpay.mobile.features.login_root.impl"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.features.auth.root.api)
            implementation(projects.shared.features.auth.login.api)
            implementation(projects.shared.features.auth.otpCode.api)
            implementation(projects.shared.compose.foundation.uikit)
            implementation(projects.shared.libraries.decompose)
        }
    }
}