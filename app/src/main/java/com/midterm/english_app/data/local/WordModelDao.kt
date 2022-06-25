package com.midterm.english_app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.midterm.english_app.data.local.entity.BookmarkEntity
import com.midterm.english_app.data.local.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM bookmarkTable")
    fun getAllBookmark(): Flow<List<BookmarkEntity>>

    @Query("SELECT * FROM historyTable")
    fun getAllHistory(): Flow<List<HistoryEntity>>

    @Delete
    suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity)

    @Delete
    suspend fun deleteHistory(historyEntity: HistoryEntity)
}