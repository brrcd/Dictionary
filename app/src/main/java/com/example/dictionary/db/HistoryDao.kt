package com.example.dictionary.db

import androidx.room.*

@Dao
interface HistoryDao {

    @Query("SELECT * FROM HistoryEntity")
    suspend fun getAll(): List<HistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWord(entity: HistoryEntity)

    @Update
    suspend fun update(entity: HistoryEntity)

    @Delete
    suspend fun delete(entity: HistoryEntity)
}