package com.example.bolo.api

import com.example.bolo.models.GetGenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreApi {
    @GET("tag.getTopTags")
    suspend fun getGenreMusics(
        @Query("api_key")
        apyKey:String
    ):GetGenreResponse

}