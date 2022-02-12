package com.example.dictionary.di

import androidx.room.Room
import com.example.dictionary.DB_NAME
import com.example.dictionary.viewmodel.MainActivityViewModel
import com.example.repository.RemoteRepository
import com.example.repository.RemoteRepositoryImpl
import com.example.database.HistoryDatabase
import com.example.dictionary.view.HistoryActivity
import com.example.dictionary.view.MainActivity
import com.example.repository.LocalRepository
import com.example.repository.LocalRepositoryImpl
import com.example.repository.MainRepository
import com.example.repository.MainRepositoryImpl
import com.example.dictionary.viewmodel.HistoryActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {

    single {
        Room.databaseBuilder(
            get(),
            HistoryDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }
    single { get<HistoryDatabase>().historyDao() }

    single<LocalRepository> { LocalRepositoryImpl(database = get()) }
    single<RemoteRepository> { RemoteRepositoryImpl() }
    single<MainRepository> { MainRepositoryImpl(localRepository = get(), remoteRepository = get()) }
}

val viewModels = module {
    scope(named<MainActivity>()) {
        viewModel { MainActivityViewModel(mainRepository = get()) }
    }
    scope(named<HistoryActivity>()) {
        viewModel { HistoryActivityViewModel(mainRepository = get()) }
    }
}