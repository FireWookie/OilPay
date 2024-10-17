import com.oilpay.app.external.androidDependencies
import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies
import com.oilpay.app.external.iosDependencies

plugins {
    alias(libs.plugins.oilpay.library)
}

android {
    namespace = "com.oilpay.mobile.core.storage.impl"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(projects.shared.core.storage.api)
            implementation(projects.shared.core.di)
            implementation(projects.shared.libraries.datastore)

            implementation(libs.kotlinx.coroutines.core)
        }
    }
}