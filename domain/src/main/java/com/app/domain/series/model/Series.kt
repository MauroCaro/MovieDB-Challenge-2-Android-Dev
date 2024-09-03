package com.app.domain.series.model

data class Series(
    val id: String? = null,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val isForAdult: Boolean,
    val releaseDate: String,
    val popularity : Double
)