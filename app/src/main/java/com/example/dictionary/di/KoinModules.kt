package com.example.dictionary.di

import androidx.room.Room
import com.example.dictionary.DB_NAME
import com.example.dictionary.viewmodel.MainActivityViewModel
import com.example.dictionary.repository.RemoteRepository
import com.example.dictionary.repository.RemoteRepositoryImpl
import com.example.dictionary.db.HistoryDatabase
import com.example.dictionary.repository.LocalRepository
import com.example.dictionary.repository.LocalRepositoryImpl
import com.example.dictionary.repository.MainRepository
import com.example.dictionary.repository.MainRepositoryImpl
import com.example.dictionary.viewmodel.HistoryActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module {

    single {
        Room.databaseBuilder(
            get(),
            HistoryDatabase::class.java,
            DB_NAME
        ).build()
    }
    single { get<HistoryDatabase>().historyDao() }

    single<LocalRepository> { LocalRepositoryImpl(get()) }
    single<RemoteRepository> { RemoteRepositoryImpl() }
    single<MainRepository> { MainRepositoryImpl(localRepository = get(), remoteRepository = get()) }
}

val viewModels = module {
    viewModel { MainActivityViewModel(mainRepository = get()) }
    viewModel { HistoryActivityViewModel(mainRepository = get()) }
}