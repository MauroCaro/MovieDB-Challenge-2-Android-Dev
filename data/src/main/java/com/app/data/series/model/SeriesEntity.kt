package com.app.data.series.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.data.base.local.IdentifyEntity

@Entity
data class SeriesEntity(
    @PrimaryKey
    override val id: String,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val isForAdult: Boolean,
    val releaseDate: String,
    val popularity: Double
) : IdentifyEntity