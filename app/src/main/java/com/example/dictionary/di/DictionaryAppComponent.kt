package com.example.dictionary.di

import android.content.Context
import com.example.dictionary.App
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [AndroidInjectionModule::class,
        MainModule::class,
        NetworkModule::class,
        ViewModelModule::class]
)
interface DictionaryAppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        fun build(): DictionaryAppComponent
    }
}