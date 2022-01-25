object Deps {

    const val CORE = Name.core + Version.core
    const val APPCOMPAT = Name.appcompat + Version.appcompat
    const val MATERIAL = Name.material + Version.material
    const val CONSTRAINT_LAYOUT = Name.constraintLayout + Version.constraintLayout
    const val JUNIT = Name.junit + Version.junit
    const val TEST_EXT_JUNIT = Name.testExtJunit + Version.textExtJunit
    const val TEST_EXT_ESPRESSO = Name.textExtEspresso + Version.textExtEspresso
    const val GSON = Name.gson + Version.gson
    const val RETROFIT_CORE = Name.retrofitCore + Version.retrofit
    const val RETROFIT_GSON_CONVERTER = Name.retrofitGsonConverter + Version.retrofit
    const val RETROFIT_ADAPTER_RXJAVA3 = Name.retrofitAdapterRxJava3 + Version.retrofit
    const val LOGGING_INTERCEPTOR = Name.loggingInterceptor + Version.loggingInterceptor
    const val LIVEDATA = Name.livedata + Version.viewModel
    const val VIEWMODEL = Name.viewModel + Version.viewModel
    const val LIFECYCLE_JAVA8 = Name.lifecycleJava8 + Version.viewModel
    const val KOIN_CORE = Name.koinCore + Version.koin
    const val KOIN_ANDROID = Name.koinAndroid + Version.koin
    const val KOIN_ANDROID_COMPAT = Name.koinAndroidCompat + Version.koin
    const val COROUTINES_CORE = Name.coroutinesCore + Version.coroutines
    const val COROUTINES_ANDROID = Name.coroutinesAndroid + Version.coroutines
    const val ROOM_RUNTIME = Name.roomRuntime + Version.room
    const val ROOM_COMPILER = Name.roomCompiler + Version.room
    const val ROOM_KTX = Name.roomKtx + Version.room
    const val SPLASH_SCREEN = Name.splashScreen + Version.splashScreen

    object Name {
        const val core = "androidx.core:core-ktx"
        const val appcompat = "androidx.appcompat:appcompat"
        const val material = "com.google.android.material:material"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout"
        const val junit = "junit:junit"
        const val testExtJunit = "androidx.test.ext:junit"
        const val textExtEspresso = "androidx.test.espresso:espresso-core"
        const val gson = "com.google.code.gson:gson"
        const val retrofitCore = "com.squareup.retrofit2:retrofit"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson"
        const val retrofitAdapterRxJava3 = "com.squareup.retrofit2:adapter-rxjava3"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel"
        const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8"
        const val koinCore = "io.insert-koin:koin-core"
        const val koinAndroid = "io.insert-koin:koin-android"
        const val koinAndroidCompat = "io.insert-koin:koin-android-compat"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android"
        const val roomRuntime = "androidx.room:room-runtime"
        const val roomCompiler = "androidx.room:room-compiler"
        const val roomKtx = "androidx.room:room-ktx"
        const val splashScreen = "androidx.core:core-splashscreen"
    }

    object Version {
        const val core = ":1.7.0"
        const val appcompat = ":1.4.1"
        const val material = ":1.5.0"
        const val constraintLayout = ":2.1.3"
        const val junit = ":4.+"
        const val textExtJunit = ":1.1.3"
        const val textExtEspresso = ":3.4.0"
        const val gson = ":2.8.6"
        const val retrofit = ":2.9.0"
        const val loggingInterceptor = ":4.9.1"
        const val viewModel = ":2.3.0"
        const val koin = ":3.1.2"
        const val coroutines = ":1.5.2"
        const val room = ":2.4.1"
        const val splashScreen = ":1.0.0-beta01"
    }
}