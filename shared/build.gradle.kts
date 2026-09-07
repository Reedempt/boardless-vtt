import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
}

sqldelight {
    databases {
        create("BoardlessDatabase") {
            packageName.set("org.boardlessvtt.app.db")
            srcDirs.setFrom("src/commonMain/sqldelight")
        }
        create("AuthDatabase") {
            packageName.set("org.boardlessvtt.app.db.auth")
            srcDirs.setFrom("src/commonMain/sqldelight-auth")
        }
        create("RulesPackDatabase") {
            packageName.set("org.boardlessvtt.app.rulespack")
            srcDirs.setFrom("src/commonMain/sqldelight-rulespack")
        }
    }
}
kotlin {
    jvm()

    android {
        namespace = "org.boardlessvtt.app.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

    }

    sourceSets.all {
        languageSettings {
            optIn("kotlin.ExperimentalUnsignedTypes")
        }
    }
        sourceSets {
            androidMain.dependencies {
                implementation(libs.compose.uiToolingPreview)
                implementation(libs.compose.uiTooling)
                implementation(libs.sqldelight.android.driver)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.server.core)
                implementation(libs.ktor.server.cio)
                implementation(libs.ktor.server.contentNegotiation)
                implementation(libs.ktor.server.websockets)
            }
            commonMain.dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.components.resources)
                implementation(libs.compose.uiToolingPreview)
                implementation(libs.androidx.lifecycle.viewmodelCompose)
                implementation(libs.androidx.lifecycle.runtimeCompose)
                implementation(libs.sqldelight.runtime)
                implementation(libs.sqldelight.coroutines)
                implementation(libs.libsodiumCrypto)
                implementation(libs.compose.materialIconsExtended)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.serialization.json)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.websockets)
            }
            commonTest.dependencies {
                implementation(libs.kotlin.test)
            }
            jvmMain.dependencies {
                implementation(libs.sqldelight.sqlite.driver)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.server.core)
                implementation(libs.ktor.server.cio)
                implementation(libs.ktor.server.contentNegotiation)
                implementation(libs.ktor.server.websockets)
            }
        }
    }

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}