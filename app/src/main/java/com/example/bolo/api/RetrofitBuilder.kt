package com.example.bolo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val genreApi = Retrofit.Builder()
        .baseUrl("https://ws.audioscrobbler.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GenreApi::class.java)
}