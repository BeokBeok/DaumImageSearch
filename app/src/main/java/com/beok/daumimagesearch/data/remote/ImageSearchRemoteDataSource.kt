package com.beok.daumimagesearch.data.remote

import com.beok.daumimagesearch.data.ImageSearchDataSource
import com.beok.daumimagesearch.data.model.ImagesItem

class ImageSearchRemoteDataSource(
    private val retrofit: ImageSearchService
) : ImageSearchDataSource {

    override fun getImageList(
        searchWord: String,
        onSuccess: (List<ImagesItem>) -> Unit,
        onFail: (Throwable) -> Unit
    ) {
    }
}