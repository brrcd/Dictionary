package com.example.dictionary.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.dictionary.WORD

@Entity
data class HistoryEntity(
    @ColumnInfo(name = WORD, index = true)
    val word: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)