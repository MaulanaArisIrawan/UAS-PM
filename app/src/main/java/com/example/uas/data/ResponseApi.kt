package com.example.uas.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class ResponseApi : ArrayList<ResponseApi.ResponseApiItem>() {
    @Parcelize
    data class ResponseApiItem(
        @SerializedName("body")
        val body: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("userId")
        val userId: Int
    ) : Parcelable
}