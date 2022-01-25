package com.example.repository

import com.example.model.DataModel
import retrofit2.Response

class MainRepositoryImpl(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) : MainRepository {
    override fun searchWord(word: String): Response<List<DataModel>> =
        remoteRepository.searchWord(word)

    override suspend fun getAllWords(): List<DataModel> =
        localRepository.getAllWords()

    override suspend fun saveWord(word: String) =
        localRepository.saveWord(word)
}

interface MainRepository {
    fun searchWord(word: String): Response<List<DataModel>>
    suspend fun getAllWords(): List<DataModel>
    suspend fun saveWord(word: String)
}