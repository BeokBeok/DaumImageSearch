package com.beok.daumimagesearch.di

import com.beok.daumimagesearch.BuildConfig
import com.beok.daumimagesearch.data.remote.ImageSearchService
import com.beok.daumimagesearch.util.KakaoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun getRemoteServiceModule(url: String) = module {
    single {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor { KakaoInterceptor.intercept(it) }
            .build()
    }
    single { GsonConverterFactory.create() }
    single { RxJava2CallAdapterFactory.create() }
    single {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
            .client(get<OkHttpClient>())
            .build()
    }
    single {
        get<Retrofit>().create(ImageSearchService::class.java)
    }
}