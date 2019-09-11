package com.beok.daumimagesearch.data.remote

import com.beok.daumimagesearch.data.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageSearchService {
    @GET("v2/search/image")
    fun getImage(
        @Query("query")
        searchWord: String
    ): Single<ImageResponse>
}