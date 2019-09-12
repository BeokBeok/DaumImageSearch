package com.beok.daumimagesearch.di

import com.beok.daumimagesearch.data.ImageSearchDataSource
import com.beok.daumimagesearch.data.ImageSearchRepository
import com.beok.daumimagesearch.data.remote.ImageSearchRemoteDataSource
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataSourceModule = module {
    single<ImageSearchDataSource>(named("repo")) { ImageSearchRepository(get()) }
    single<ImageSearchDataSource> { ImageSearchRemoteDataSource(get()) }
}