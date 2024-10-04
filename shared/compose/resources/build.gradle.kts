import com.oilpay.app.external.applyTargets
import com.oilpay.app.external.commonDependencies

plugins {
    alias(libs.plugins.oilpay.library)
    alias(libs.plugins.oilpay.compose)
}

android {
    namespace = "com.oilpay.mobile.compose.resources"
}

kotlin {
    applyTargets()

    sourceSets {
        commonDependencies {
            implementation(compose.runtime)
            api(compose.components.resources)
        }
    }
}

compose.resources {
    packageOfResClass = "com.oilpay.mobile.compose.resources"
    generateResClass = always
    publicResClass = true
}