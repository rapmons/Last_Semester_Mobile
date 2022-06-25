package com.midterm.english_app.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midterm.english_app.data.repository.WordRepository
import com.midterm.english_app.domain.model.WordModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val wordRepo: WordRepository): ViewModel() {
    var history = MutableStateFlow(listOf<WordModel>())
        private set

}