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

include(":shared:core:network:api")
include(":shared:core:network:impl")

include(":shared:core:storage:api")
include(":shared:core:storage:impl")

include(":shared:core:di")

include(":shared:compose:foundation:theme")
include(":shared:compose:foundation:core")
include(":shared:compose:foundation:uikit")
include(":shared:compose:foundation:icons")

include(":shared:features:auth:login:api")
include(":shared:features:auth:login:impl")

include(":shared:features:auth:otp_code:api")
include(":shared:features:auth:otp_code:impl")

include(":shared:features:auth:security:api")
include(":shared:features:auth:security:impl")

include(":shared:features:auth:identification:api")
include(":shared:features:auth:identification:impl")

include(":shared:features:auth:root:api")
include(":shared:features:auth:root:impl")

include(":shared:common-network")
include(":shared:umbrella-core")

include(":shared:features:onboarding:api")
include(":shared:features:onboarding:impl")

include(":shared:features:root")

include(":shared:libraries:decompose")
include(":shared:libraries:datastore")
include(":shared:libraries:platform")

include(":shared:compose:resources")

