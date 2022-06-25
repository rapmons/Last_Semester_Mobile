package com.midterm.english_app.data.repository


import com.midterm.english_app.data.local.entity.BookmarkEntity
import com.midterm.english_app.data.local.entity.HistoryEntity
import com.midterm.english_app.domain.repository.WordBaseRepository
import com.midterm.english_app.data.local.WordModelDao
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class WordRepository @Inject constructor(
    private val wordModelDao: WordModelDao
) : WordBaseRepository {

    override suspend fun insertBookmark(bookmarkEntity: BookmarkEntity) {
        wordModelDao.insertBookmark(bookmarkEntity)
    }

    override suspend fun insertHistory(historyEntity: HistoryEntity) {
        wordModelDao.insertHistory(historyEntity)
    }

    override suspend fun getAllBookmark(): Flow<List<BookmarkEntity>> =
        wordModelDao.getAllBookmark()

    override suspend fun getAllHistory(): Flow<List<HistoryEntity>> =
        wordModelDao.getAllHistory()

    override suspend fun deleteBookmark(bookmarkEntity: BookmarkEntity) {
        wordModelDao.deleteBookmark(bookmarkEntity)
    }

    override suspend fun deleteHistory(historyEntity: HistoryEntity) {
        wordModelDao.deleteHistory(historyEntity)
    }
}