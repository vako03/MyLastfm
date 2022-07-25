package com.example.bolo.api

import com.example.bolo.MusicDetailFragment
import com.example.bolo.models.GetGenreResponse
import com.example.bolo.models.Tag
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GenreApi {
    @GET("tag/getTopTags")
    suspend fun getGenreMusics(
        @Query("api_key")
        apyKey:String
    ):GetGenreResponse

    @GET("music/{tag.gettopalbums}")
        suspend fun  getMusicDetails(
        @Path("tag.gettopalbums}")
        tag: Int,
        @Query("api_key")
        apyKey: String
    ):MusicDetailFragment
}