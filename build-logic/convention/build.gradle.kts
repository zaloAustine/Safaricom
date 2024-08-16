plugins {
    `kotlin-dsl`
}
group = "com.shoppa.buildlogic"

java {
    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        compileOnly(libs.android.gradle)
        compileOnly(libs.kotlin.gradle)
        compileOnly(libs.ksp.gradlePlugin)
    }

}

gradlePlugin {
    plugins {
        register("androidApp"){
            id = "zalo.app"
            implementationClass = "com.AndroidApplicationConventionPlugin"
        }

        register("androidLibrary"){
            id = "zalo.library"
            implementationClass = "com.AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "zalo.hilt"
            implementationClass = "com.AndroidHiltConventionPlugin"
        }

        register("androidApplicationCompose") {
            id = "zalo.app.compose"
            implementationClass = "com.AndroidApplicationComposeConventionPlugin"
        }

        register("androidApplicationNetwork") {
            id = "zalo.app.network"
            implementationClass = "com.AndroidApplicationNetworkConventionPlugin"
        }

        register("androidLibraryNetwork") {
            id = "zalo.library.network"
            implementationClass = "com.AndroidLibraryNetworkConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "zalo.library.compose"
            implementationClass = "com.AndroidLibraryComposeConventionPlugin"
        }
        register("androidTesting") {
            id = "zalo.testing"
            implementationClass = "com.TestingConventionPlugin"
        }
        register("androidRoom") {
            id = "zalo.android.room"
            implementationClass = "com.AndroidRoomConventionPlugin"
        }
    }
}