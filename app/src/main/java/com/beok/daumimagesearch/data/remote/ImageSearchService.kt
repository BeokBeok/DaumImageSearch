package com.beok.daumimagesearch.data.remote

import com.beok.daumimagesearch.data.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ImageSearchService {

    @Headers("Authorization: KakaoAK 7152b9bf3a3d93354032271f565d1cfe")
    @GET("v2/search/image")
    fun getImage(
        @Query("query")
        searchWord: String
    ): Single<ImageResponse>
}