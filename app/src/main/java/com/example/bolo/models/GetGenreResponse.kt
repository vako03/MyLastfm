package com.example.bolo.models


import com.google.gson.annotations.SerializedName

data class GetGenreResponse(
    @SerializedName("toptags")
    val genre: Genre
)