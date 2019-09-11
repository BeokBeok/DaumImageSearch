package com.beok.daumimagesearch.data.model

import com.google.gson.annotations.SerializedName

data class ImagesItem(

    @SerializedName("image_url")
    val imageUrl: String,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int
)