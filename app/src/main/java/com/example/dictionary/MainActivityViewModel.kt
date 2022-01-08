package com.example.dictionary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel
@Inject constructor(private val repository: Repository) : ViewModel() {
    private val liveData: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveData

    fun searchWords(word: String) {
        liveData.value = AppState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.searchWord(word)

            if (data != null) {
                if (data.isEmpty())
                    liveData.postValue(AppState.Error(LIST_IS_EMPTY))
                else
                    liveData.postValue(AppState.Success(data))
            }
            else {
                liveData.postValue(AppState.Error(BAD_REQUEST))
            }
        }
    }

    companion object {
        const val LIST_IS_EMPTY = "List is empty"
        const val BAD_REQUEST = "Bad request"
    }
}