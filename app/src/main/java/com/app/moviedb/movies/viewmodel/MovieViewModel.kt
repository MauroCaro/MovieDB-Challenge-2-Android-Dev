package com.app.moviedb.movies.viewmodel

import com.app.domain.movies.uc.GetMoviesUC
import com.app.moviedb.base.viewmodel.BaseViewModel
import com.app.moviedb.movies.mapper.MovieUIMapper
import com.app.moviedb.movies.model.MovieUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieUIMapper: MovieUIMapper,
    private val getMoviesUC: GetMoviesUC
) : BaseViewModel<MovieUIState>(MovieUIState.Loading) {

    init {
        loadMovies()
    }

    private fun loadMovies() = launchWithErrorHandlingDefault {
        getMoviesUC.invoke().collect {
            _state.value = movieUIMapper.buildUI(it)
        }
    }
}