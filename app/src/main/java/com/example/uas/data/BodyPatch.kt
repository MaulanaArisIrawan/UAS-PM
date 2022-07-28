package com.example.uas.data

import com.google.gson.annotations.SerializedName

data class BodyPatch(
    @SerializedName("body")
    val body: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int
)