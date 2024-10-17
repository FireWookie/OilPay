import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)

}

android {
    namespace = "com.oilpay.mobile.features.auth.login"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {

        }
    }
}