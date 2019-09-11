package com.beok.daumimagesearch.di

import com.beok.daumimagesearch.data.ImageSearchRepository
import com.beok.daumimagesearch.data.remote.ImageSearchRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { ImageSearchRepository(get()) }
    single { ImageSearchRemoteDataSource(get()) }
}