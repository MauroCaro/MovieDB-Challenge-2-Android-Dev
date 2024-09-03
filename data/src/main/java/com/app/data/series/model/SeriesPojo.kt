package com.app.data.series.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeriesPojo(
    @Expose
    @SerializedName("id")
    var id: String,
    @Expose
    @SerializedName("original_name")
    var title: String,
    @Expose
    @SerializedName("overview")
    var overview: String,
    @Expose
    @SerializedName("poster_path")
    var posterPath: String,
    @Expose
    @SerializedName("vote_average")
    var voteAverage: Double,
    @Expose
    @SerializedName("adult")
    var isForAdult: Boolean,
    @Expose
    @SerializedName("first_air_date")
    var releaseDate: String,
    @Expose
    @SerializedName("popularity")
    var popularity: Double,
)