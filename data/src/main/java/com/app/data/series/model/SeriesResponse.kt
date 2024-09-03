package com.app.data.series.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("results")
    val results: List<SeriesPojo>,
    @Expose
    @SerializedName("total_pages")
    val totalPages: Int,
    @Expose
    @SerializedName("total_results")
    val totalResults: Int
)