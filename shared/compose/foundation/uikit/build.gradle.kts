import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)
}

android {
    namespace = "com.oilpay.mobile.foundation.uikit"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.compose.resources)

            api(projects.shared.compose.foundation.core)

            api(compose.foundation)
            api(compose.material3)
            api(compose.runtime)
            api(compose.ui)
        }
    }
}