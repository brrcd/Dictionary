package com.example.dictionary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dictionary.AppState
import com.example.dictionary.LIST_IS_EMPTY
import com.example.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class HistoryActivityViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun loadHistory() =
        flow {
            emit(AppState.Loading)
            val data = mainRepository.getAllWords()
            if (data.isEmpty()) {
                emit(AppState.Error(LIST_IS_EMPTY))
            } else {
                emit(AppState.Success(data))
            }
        }.flowOn(Dispatchers.IO)
            .asLiveData()
}