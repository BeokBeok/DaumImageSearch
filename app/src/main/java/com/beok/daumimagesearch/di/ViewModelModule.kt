package com.beok.daumimagesearch.di

import com.beok.daumimagesearch.imagesearch.ImageSearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ImageSearchViewModel(get()) }
}