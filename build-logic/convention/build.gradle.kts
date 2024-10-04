plugins {
    `kotlin-dsl`
}

group = "com.oilpay.app"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.compose.compiler.plugin)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("oilpay.library") {
            id = "oilpay.library"
            implementationClass = "AndroidKmpLibraryPlugin"
        }
        register("oilpay.compose") {
            id = "oilpay.compose"
            implementationClass = "KmpComposePlugin"
        }
        register("oilpay.application") {
            id = "oilpay.application"
            implementationClass = "AndroidApplicationPlugin"
        }
    }
}