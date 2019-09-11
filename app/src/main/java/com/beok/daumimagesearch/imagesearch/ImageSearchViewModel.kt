package com.beok.daumimagesearch.imagesearch

import com.beok.daumimagesearch.base.BaseViewModel
import com.beok.daumimagesearch.data.ImageSearchRepository

class ImageSearchViewModel(
    private val imageSearchRepository: ImageSearchRepository
) : BaseViewModel() {

    fun searchImage(searchWord: String) {
        imageSearchRepository.searchImage(
            searchWord,
            onSuccess = {

            },
            onFail = {

            }
        )
    }
}