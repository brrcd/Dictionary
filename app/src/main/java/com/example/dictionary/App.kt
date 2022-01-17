package com.example.dictionary

import android.app.Application
import com.example.dictionary.di.application
import com.example.dictionary.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(application, viewModels))
        }
    }
}