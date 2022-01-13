package com.example.dictionary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.dictionary.AppState
import com.example.dictionary.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainActivityViewModel(private val repository: Repository) : ViewModel() {

    fun searchWord(word: String) =
        flow {
            emit(AppState.Loading)
            val data = repository.searchWord(word).body()
            if (data != null) {
                if (data.isEmpty())
                    emit(AppState.Error(LIST_IS_EMPTY))
                else
                    emit(AppState.Success(data))
            } else {
                emit(AppState.Error(BAD_REQUEST))
            }
        }.flowOn(Dispatchers.IO)
            .asLiveData()


    companion object {
        const val LIST_IS_EMPTY = "List is empty"
        const val BAD_REQUEST = "Bad request"
    }
}