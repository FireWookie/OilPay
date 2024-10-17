import com.oilpay.app.external.androidDependencies
import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies
import com.oilpay.app.external.iosDependencies

plugins {
    alias(libs.plugins.oilpay.library)
}

android {
    namespace = "com.oilpay.mobile.core.di"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            api(libs.koin.core)
        }
    }
}