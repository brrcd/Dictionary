package com.example.dictionary.di

import com.example.dictionary.MainActivityViewModel
import com.example.dictionary.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideMainActivityViewModel(repository: RepositoryImpl): MainActivityViewModel =
        MainActivityViewModel(repository)
}