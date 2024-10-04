rootProject.name = "OilPay"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content { 
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            content { 
              	includeGroupByRegex("com\\.android.*")
              	includeGroupByRegex("com\\.google.*")
              	includeGroupByRegex("androidx.*")
              	includeGroupByRegex("android.*")
            }
        }
        mavenCentral()
    }
}
include(":composeApp")

include(":shared:compose:foundation:theme")
include(":shared:compose:foundation:core")
include(":shared:compose:foundation:uikit")
include(":shared:compose:foundation:icons")

include(":shared:features:auth:login:api")
include(":shared:features:auth:login:data")
include(":shared:features:auth:login:ui")

include(":shared:features:auth:security")
include(":shared:features:auth:identification")
include(":shared:features:auth:root")

include(":shared:common-network")
include(":shared:umbrella-core")

include(":shared:features:onboarding")
include(":shared:features:root")

include(":shared:libraries:decompose")
include(":shared:libraries:datastore")
include(":shared:libraries:platform")

include(":shared:compose:resources")

