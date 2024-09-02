package com.app.domain.series

import com.app.domain.base.BaseRepository
import com.app.domain.movies.model.Movie
import kotlinx.coroutines.flow.Flow

interface SeriesRepository : BaseRepository<Movie> {

    fun getAll(): Flow<List<Movie>>
}