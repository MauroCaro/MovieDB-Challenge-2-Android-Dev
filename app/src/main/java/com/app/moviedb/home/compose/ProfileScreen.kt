package com.app.moviedb.home.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(innerPadding: androidx.compose.foundation.layout.PaddingValues) {
    Text(text = "Profile", modifier = Modifier.padding(innerPadding))
}