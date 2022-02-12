plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.dictionary"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        buildFeatures.viewBinding = true
    }
}

dependencies {
    implementation(project(":repository"))
    implementation(project(":model"))
    implementation(project(":database"))

    implementation(Deps.CORE)
    implementation(Deps.APPCOMPAT)
    implementation(Deps.MATERIAL)
    implementation(Deps.CONSTRAINT_LAYOUT)
    testImplementation(Deps.JUNIT)
    androidTestImplementation(Deps.TEST_EXT_JUNIT)
    androidTestImplementation(Deps.TEST_EXT_ESPRESSO)
    // ViewModel
    implementation(Deps.LIVEDATA)
    implementation(Deps.VIEWMODEL)
    implementation(Deps.LIFECYCLE_JAVA8)
    // Koin
    implementation(Deps.KOIN_CORE)
    implementation(Deps.KOIN_ANDROID)
    implementation(Deps.KOIN_ANDROID_COMPAT)
    // Coroutines
    implementation(Deps.COROUTINES_CORE)
    implementation(Deps.COROUTINES_ANDROID)
    // retrofit
    implementation(Deps.RETROFIT_CORE)
    // SplashScreen
    implementation(Deps.SPLASH_SCREEN)
}