package com.app.data.movies.remote

import com.app.data.movies.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieAPI {

    @GET("discover/movie")
    suspend fun getAllMovies(): MovieResponse

}