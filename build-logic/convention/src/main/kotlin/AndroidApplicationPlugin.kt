import com.oilpay.app.external.compilerOptions
import com.oilpay.app.internal.applicationExtension
import com.oilpay.app.internal.applicationPluginId
import com.oilpay.app.internal.configureKotlinAndroidToolchain
import com.oilpay.app.internal.kotlinExtension
import com.oilpay.app.internal.kotlinPluginId
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        apply(plugin = applicationPluginId)
        apply(plugin = kotlinPluginId)

        applicationExtension {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }

            kotlinExtension {
                compilerOptions {
                    freeCompilerArgs.add("-Xcontext-receivers")
                }
            }

            buildTypes {
                release {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        "proguard-rules.pro",
                        getDefaultProguardFile("proguard-android-optimize.txt")
                    )
                }
            }
        }
        configureKotlinAndroidToolchain()
    }
}