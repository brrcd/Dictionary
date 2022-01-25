plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 26
        targetSdk = 31

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
}

dependencies {
    implementation(project(":model"))

    implementation(Deps.CORE)

    // retrofit
    implementation(Deps.RETROFIT_CORE)
    implementation(Deps.RETROFIT_GSON_CONVERTER)
    implementation(Deps.RETROFIT_ADAPTER_RXJAVA3)

    // loggingInterceptor
    implementation(Deps.LOGGING_INTERCEPTOR)
}