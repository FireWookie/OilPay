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

            implementation(projects.shared.features.auth.login.impl)
            implementation(projects.shared.features.auth.root.impl)
            implementation(projects.shared.features.onboarding.impl)
            implementation(projects.shared.features.splash.impl)

            implementation(projects.shared.core.storage.impl)
            implementation(projects.shared.core.network.impl)
            implementation(projects.shared.libraries.datastore)
        }
    }
}