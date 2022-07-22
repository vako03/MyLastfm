package com.example.bolo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val genreApi = Retrofit.Builder()
        .baseUrl("http://ws.audioscrobbler.com/2.0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GenreApi::class.java)
}