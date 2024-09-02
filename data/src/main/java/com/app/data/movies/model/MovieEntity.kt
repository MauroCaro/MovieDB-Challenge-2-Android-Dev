package com.app.data.movies.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.data.base.local.IdentifyEntity

@Entity
data class MovieEntity(
    @PrimaryKey
    override val id: String,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val isForAdult: Boolean,
    val releaseDate: String
) : IdentifyEntity