package com.beok.daumimagesearch.util

import okhttp3.Interceptor
import okhttp3.Response

object KakaoInterceptor : Interceptor {

    private const val API_KEY = "7152b9bf3a3d93354032271f565d1cfe"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "KakaoAK $API_KEY")
            .build()
        return chain.proceed(request)
    }
}