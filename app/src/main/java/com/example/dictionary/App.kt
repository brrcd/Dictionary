package com.example.dictionary

import com.example.dictionary.di.DaggerDictionaryAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerDictionaryAppComponent
            .builder()
            .withContext(applicationContext)
            .build()
}