package com.app.data.series.remote

import com.app.data.series.model.SeriesResponse
import retrofit2.http.GET

interface SeriesAPI {


    @GET("discover/tv")
    suspend fun getAllSeries(): SeriesResponse
}