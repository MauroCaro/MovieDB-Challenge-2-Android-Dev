package com.app.data.base.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    val provideRetrofit: Retrofit by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZTZjZjk2ZGI5M2E4ODY4NmQ1ZTUzOGNhYmEyNDc3YiIsIm5iZiI6MTcyNTE1OTU3Ny45Njg4NzEsInN1YiI6IjViYWVhMjMwMGUwYTI2MWUyODAwYjM4YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.3gk1pTiT_8ODFDAHA_L1EZGFI4wFVC0tM05MGBH__C8")) // For API token AUTH since this is static I will use a different way to save this
            .build()

        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/") // For URL I will receive it sa parameter since we can have different for prod, stage or dev
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}