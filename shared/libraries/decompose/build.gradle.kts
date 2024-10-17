import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)

}

android {
    namespace = "com.oilpay.mobile.libraries.decompose"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            api(libs.decompose.compose)
            api(libs.decompose)
            api(libs.essenty.lifecycle)

            implementation(libs.kotlinx.coroutines.core)
            implementation(projects.shared.libraries.platform)

            api(libs.koin.core)
            api(libs.viewmodel.compose)
            api(libs.mvi.orbit)
        }
    }
}