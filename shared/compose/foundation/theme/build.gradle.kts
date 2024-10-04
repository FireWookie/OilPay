import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)
}

android {
    namespace = "com.oilpay.mobile.foundation.theme"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.compose.resources)
            implementation(compose.material3)
        }
    }
}