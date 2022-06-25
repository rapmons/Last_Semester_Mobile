package com.midterm.english_app.domain.model

import com.midterm.english_app.data.local.entity.BookmarkEntity
import com.midterm.english_app.data.local.entity.HistoryEntity
import com.midterm.english_app.data.local.entity.Meaning

data class WordModel(
    val meanings: List<Meaning>?,
    val word: String,
    val wordsetId: String
) {
    fun toBookmarkEntity(): BookmarkEntity {
        return BookmarkEntity(meanings, word, wordsetId)
    }

    fun toHistoryEntity(): HistoryEntity {
        return HistoryEntity(meanings, word, wordsetId)
    }
}