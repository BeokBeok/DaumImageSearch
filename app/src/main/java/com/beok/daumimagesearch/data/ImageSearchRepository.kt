package com.beok.daumimagesearch.data

import com.beok.daumimagesearch.data.model.ImagesItem
import com.beok.daumimagesearch.data.remote.ImageSearchRemoteDataSource

class ImageSearchRepository(
    private val imageSearchRemoteDataSource: ImageSearchRemoteDataSource
) {

    fun searchImage(
        searchWord: String,
        onSuccess: (List<ImagesItem>) -> Unit,
        onFail: (Throwable) -> Unit
    ) = imageSearchRemoteDataSource.getImageList(
        searchWord,
        onSuccess,
        onFail
    )
}