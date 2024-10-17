import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)

}

android {
    namespace = "com.oilpay.mobile.core.network.api"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {

        }
    }
}