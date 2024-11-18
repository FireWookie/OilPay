import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)

}

android {
    namespace = "com.oilpay.mobile.features.pin_code.impl"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.compose.resources)

            implementation(projects.shared.features.auth.pinCode.api)
            implementation(projects.shared.compose.foundation.uikit)
            implementation(projects.shared.libraries.decompose)
        }
    }
}