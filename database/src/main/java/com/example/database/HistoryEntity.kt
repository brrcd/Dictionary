package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    @ColumnInfo(name = WORD, index = true)
    val word: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)