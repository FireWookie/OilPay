import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
}

android {
    namespace = "com.oilpay.mobile.umbrella_core"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(libs.koin.core)
        }
    }
}