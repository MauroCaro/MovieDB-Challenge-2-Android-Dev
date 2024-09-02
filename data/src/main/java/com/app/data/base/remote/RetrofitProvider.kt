package com.app.data.base.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    val provideRetrofit: Retrofit by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor("token")) // For API token AUTH since this is static I will use a different way to save this
            .build()

        Retrofit.Builder()
            .baseUrl("https://api.example.com/") // For URL I will receive it sa parameter since we can have different for prod, stage or dev
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}