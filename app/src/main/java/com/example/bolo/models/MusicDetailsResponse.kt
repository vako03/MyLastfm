package com.example.bolo.models


import com.google.gson.annotations.SerializedName

data class MusicDetailsResponse(
    @SerializedName("albums")
    val albums: Albums
)