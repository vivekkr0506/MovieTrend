plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinKapt)
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
        debug{
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            buildConfigField("String","API_KEY","\"ddb66e8aa3deddd8f5cca8b9d9dda602\"")
            buildConfigField("String","BASE_URL","\"https://api.themoviedb.org/3/\"")
            buildConfigField("String","PLACE_HOLDER_IMAGE","\"https://image.tmdb.org/t/p/w500\"")
            buildConfigField("String", "TOKEN", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkZGI2NmU4YWEzZGVkZGQ4ZjVjY2E4YjlkOWRkYTYwMiIsIm5iZiI6MTcyNTA5MTYxMy43NDk2MjMsInN1YiI6IjY2ZDJjZDNhYjYzMDJkMWY1NDk2NWI4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8XwDavoVcRdw_nwlBqpX6M3u8TPYiIVW3CtlBdrZ-pQ\"")
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String","API_KEY","\"ddb66e8aa3deddd8f5cca8b9d9dda602\"")
            buildConfigField("String","BASE_URL","\"https://api.themoviedb.org/3/\"")
            buildConfigField("String","PLACE_HOLDER_IMAGE","\"https://image.tmdb.org/t/p/w500\"")
            buildConfigField("String", "TOKEN", "\"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJkZGI2NmU4YWEzZGVkZGQ4ZjVjY2E4YjlkOWRkYTYwMiIsIm5iZiI6MTcyNTA5MTYxMy43NDk2MjMsInN1YiI6IjY2ZDJjZDNhYjYzMDJkMWY1NDk2NWI4OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8XwDavoVcRdw_nwlBqpX6M3u8TPYiIVW3CtlBdrZ-pQ\"")
            signingConfig = signingConfigs.getByName("debug")
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
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.multidex)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.kotlin.stdlib)
    ksp(libs.hilt.compiler)

    implementation(libs.coil.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}