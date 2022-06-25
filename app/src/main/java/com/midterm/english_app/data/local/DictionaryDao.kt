package com.midterm.english_app.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.midterm.english_app.data.local.entity.DictionaryEntity

@Dao
interface DictionaryDao {
    @RawQuery
    suspend fun prefixMatch(query: SupportSQLiteQuery): List<DictionaryEntity>

    @RawQuery
    suspend fun search(query: SupportSQLiteQuery): DictionaryEntity
}