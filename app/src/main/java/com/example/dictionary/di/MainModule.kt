package com.example.dictionary.di

import com.example.dictionary.MainActivity
import com.example.dictionary.MainActivityViewModel
import com.example.dictionary.Repository
import com.example.dictionary.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface MainModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @Binds
    fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}