package com.example.bolo.models


import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("@attr")
    val attr: AttrX,
    @SerializedName("image")
    val image: List<Image>,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)