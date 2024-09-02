package com.app.data.movies.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MoviePojo(
    @Expose
    @SerializedName("id")
    var id: String,
    @Expose
    @SerializedName("title")
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
    @SerializedName("release_date")
    var releaseDate: String,
)