import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)
}

android {
    namespace = "com.oilpay.mobile.foundation.core"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            api(projects.shared.compose.foundation.theme)

            api(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
        }
    }
}