package com.midterm.english_app.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midterm.english_app.data.repository.WordRepository
import com.midterm.english_app.domain.model.WordModel
import com.midterm.english_app.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val wordRepo: WordRepository): ViewModel() {
    var bookmarks = MutableStateFlow(listOf<WordModel>())
        private set

 
}