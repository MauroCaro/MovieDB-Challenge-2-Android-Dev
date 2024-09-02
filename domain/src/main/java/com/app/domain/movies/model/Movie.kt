package com.app.domain.movies.model

data class Movie(
    val id: String? = null,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val isForAdult: Boolean,
    val releaseDate: String
)