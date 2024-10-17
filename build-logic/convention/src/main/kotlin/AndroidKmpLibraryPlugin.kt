import com.oilpay.app.internal.kmpExtension
import com.oilpay.app.internal.kotlinMultiplatformPluginId
import com.oilpay.app.internal.libraryExtension
import com.oilpay.app.internal.libraryPluginId
import com.oilpay.app.internal.libs
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.apply
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

class AndroidKmpLibraryPlugin : Plugin<Project> {

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    override fun apply(target: Project) = with(target) {
        apply(plugin = libraryPluginId)
        apply(plugin = kotlinMultiplatformPluginId)

        kmpExtension {
            compilerOptions {
                freeCompilerArgs.addAll(
                    "-Xcontext-receivers",
                    "-Xexpect-actual-classes"
                )
            }

            sourceSets {
                all {
                    languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
                }
            }
        }

        libraryExtension {
            defaultConfig {
                minSdk = libs.versions.minSdk.get().toInt()
                compileSdk = libs.versions.compileSdk.get().toInt()

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }
        }
    }
}

fun KotlinMultiplatformExtension.sourceSets(
    configure: Action<NamedDomainObjectContainer<KotlinSourceSet>>
): Unit = (this as ExtensionAware).extensions.configure("sourceSets", configure)