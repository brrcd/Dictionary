package com.example.dictionary.di

import com.example.dictionary.viewmodel.MainActivityViewModel
import com.example.dictionary.Repository
import com.example.dictionary.RepositoryImpl
import org.koin.dsl.module

val application = module {
    single<Repository> { RepositoryImpl() }
}

val mainScreen = module {
    factory { MainActivityViewModel( repository = get()) }
}