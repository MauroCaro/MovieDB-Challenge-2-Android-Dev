package com.app.moviedb.movies.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MoviesScreen(innerPadding: androidx.compose.foundation.layout.PaddingValues) {
    Text(text = "Movies", modifier = Modifier.padding(innerPadding))
}