package com.example.bolo.models


import com.google.gson.annotations.SerializedName

data class AttrXX(
    @SerializedName("page")
    val page: String,
    @SerializedName("perPage")
    val perPage: String,
    @SerializedName("tag")
    val tag: String,
    @SerializedName("total")
    val total: String,
    @SerializedName("totalPages")
    val totalPages: String
)