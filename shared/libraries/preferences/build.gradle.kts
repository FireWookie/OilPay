import com.oilpay.app.external.androidDependencies
import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
}

android {
    namespace = "com.oilpay.mobile.libraries.preferences"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            api(projects.shared.libraries.datastore)
        }
    }
}