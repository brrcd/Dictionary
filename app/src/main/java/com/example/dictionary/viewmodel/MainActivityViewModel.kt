package com.example.dictionary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dictionary.AppState
import com.example.dictionary.BAD_REQUEST
import com.example.dictionary.LIST_IS_EMPTY
import com.example.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainActivityViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun searchWord(word: String) =
        flow {
            emit(AppState.Loading)
            val data = mainRepository.searchWord(word).body()
            if (data != null) {
                if (data.isEmpty())
                    emit(AppState.Error(LIST_IS_EMPTY))
                else {
                    emit(AppState.Success(data))
                    mainRepository.saveWord(word)
                }
            } else {
                emit(AppState.Error(BAD_REQUEST))
            }
        }.flowOn(Dispatchers.IO)
            .asLiveData()
}