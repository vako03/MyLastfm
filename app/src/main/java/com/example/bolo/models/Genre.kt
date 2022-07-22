package com.example.bolo.models


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("@attr")
    val attr: Attr,
    @SerializedName("tag")
    val tag: List<Tag>
)