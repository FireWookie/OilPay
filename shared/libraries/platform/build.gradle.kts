import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
}

android {
    namespace = "com.oilpay.mobile.libraries.platform"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}