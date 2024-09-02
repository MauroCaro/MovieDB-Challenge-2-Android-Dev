package com.app.moviedb.movies.model

import kotlinx.collections.immutable.ImmutableList

sealed class MovieUIState {
    data object Loading : MovieUIState()
    data class Show(val movies: ImmutableList<MovieUI>) : MovieUIState()
    data class Empty(val movies: ImmutableList<MovieUI>) : MovieUIState()
}