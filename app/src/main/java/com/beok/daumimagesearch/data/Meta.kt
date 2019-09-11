package com.beok.daumimagesearch.data

import com.google.gson.annotations.SerializedName

data class Meta(

    @SerializedName("total_count")
    val totalCount: Int,

    @SerializedName("is_end")
    val isEnd: Boolean,

    @SerializedName("pageable_count")
    val pageableCount: Int
)