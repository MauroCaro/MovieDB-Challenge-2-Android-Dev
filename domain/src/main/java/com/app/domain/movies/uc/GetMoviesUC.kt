package com.app.domain.movies.uc

import com.app.domain.movies.MovieRepository
import com.app.domain.movies.model.Movie
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class GetMoviesUC @Inject constructor(
    private val movieRepository: MovieRepository
) {

    fun invoke(): Flow<List<Movie>> {
        return movieRepository.getAll()
    }
}