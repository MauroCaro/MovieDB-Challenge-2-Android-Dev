package com.app.moviedb.series.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.moviedb.base.main.theme.AppTheme
import com.app.moviedb.movies.compose.MovieItem
import com.app.moviedb.movies.model.MovieUI
import com.app.moviedb.movies.model.MovieUIState
import com.app.moviedb.movies.viewmodel.MovieViewModel
import com.app.ui_common.components.util.GeneralEmptyScreen
import com.app.ui_common.components.util.GeneralLoadingScreen
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun SeriesScreen(
    innerPadding: PaddingValues,
    viewModel: MovieViewModel = hiltViewModel(),
) {
    val stateUI by viewModel.state.collectAsStateWithLifecycle()
    when (val state = stateUI) {
        is MovieUIState.Loading -> GeneralLoadingScreen()
        is MovieUIState.Empty -> GeneralEmptyScreen()
        is MovieUIState.Show -> {
            Series(innerPadding, state.movies)
        }
    }
}

@Composable
fun Series(
    innerPadding: PaddingValues,
    movies: ImmutableList<MovieUI>,
) {
    Box(
        Modifier
            .padding(innerPadding)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(movies.size) { index ->
                MovieItem(movie = movies[index])
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSeries() {
    AppTheme {
        Series(
            PaddingValues(),
            persistentListOf(
                MovieUI("1", "The Shawshank Redemption", "https://image.tmdb.org/t/p/w500/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg"),
                MovieUI("3", "The Dark Knight", "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg")
            )
        )
    }
}