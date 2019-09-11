package com.beok.daumimagesearch.data

import com.google.gson.annotations.SerializedName

data class ImageResponse(

    @SerializedName("documents")
    val documents: List<ImagesItem?>,

    @SerializedName("meta")
    val meta: Meta
)