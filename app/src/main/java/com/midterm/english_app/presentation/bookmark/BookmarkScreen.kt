package com.midterm.english_app.presentation.bookmark

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.midterm.english_app.domain.model.WordModel
import com.midterm.english_app.presentation.bookmark.components.BookmarkItem
import com.midterm.english_app.presentation.ui.theme.blueText

@ExperimentalUnitApi
@Composable
fun BookmarkScreen(viewModel: BookmarkViewModel, onItemClick: (Int) -> Unit) {
    val bookmarks by viewModel.bookmarks.collectAsState()

    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Bookmarks",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
                        .align(Alignment.Start)
                )

               
            }
           
        }
    }

}

@ExperimentalUnitApi
@Composable
fun BookmarkList(
    list: List<WordModel>,
    onItemClick: (Int) -> Unit,
    onDeleteClick: (WordModel) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
        itemsIndexed(list) { index, item ->
            BookmarkItem(index, wordModel = item, onItemClick, onDeleteClick)
        }
    }
}