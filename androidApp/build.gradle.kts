plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.bm.Droid.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.BM.Droid.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dependencies {
        implementation(project(":shared"))

        implementation(libs.androidx.compose.ui)
        implementation(libs.androidx.compose.ui.tooling)
        implementation(libs.androidx.compose.foundation)
        implementation(libs.androidx.compose.material)
        implementation(libs.androidx.compose.runtime)
        implementation(libs.activity.compose)

        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)

        implementation(libs.koin.core)
        implementation(libs.koin.android)

        implementation(libs.kviewmodel.core)
        implementation(libs.kviewmodel.compose)
        implementation(libs.kviewmodel.odyssey)

        implementation(libs.odyssey.core)
        implementation(libs.odyssey.compose)
    }
}