import org.apache.commons.compress.harmony.pack200.PackingUtils.config

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.vivek.movietrend"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vivek.movietrend"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "TOKEN", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkZGI2NmU4YWEzZGVkZGQ4ZjVjY2E4YjlkOWRkYTYwMiIsIm5iZiI6MTcyNTA5MTYxMy43NDk2MjMsInN1YiI6IjY2ZDJjZDNhYjYzMDJkMWY1NDk2NWI4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8XwDavoVcRdw_nwlBqpX6M3u8TPYiIVW3CtlBdrZ-pQ\"")
            signingConfig = signingConfigs.getByName("debug")
        }
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            buildConfigField("String", "TOKEN", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkZGI2NmU4YWEzZGVkZGQ4ZjVjY2E4YjlkOWRkYTYwMiIsIm5iZiI6MTcyNTA5MTYxMy43NDk2MjMsInN1YiI6IjY2ZDJjZDNhYjYzMDJkMWY1NDk2NWI4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8XwDavoVcRdw_nwlBqpX6M3u8TPYiIVW3CtlBdrZ-pQ\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Retrofit for API calls
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.gson)

    // ViewModel and LiveData
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.lifecycle.livedata.ktx)

    //Image Loading
    implementation(libs.coil.compose)

    //Coroutines
    implementation (libs.kotlinx.coroutines.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}