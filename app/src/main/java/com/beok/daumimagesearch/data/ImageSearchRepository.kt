package com.beok.daumimagesearch.data

import com.beok.daumimagesearch.data.model.ImageResponse
import com.beok.daumimagesearch.data.remote.ImageSearchRemoteDataSource
import io.reactivex.disposables.Disposable

class ImageSearchRepository(
    private val imageSearchRemoteDataSource: ImageSearchRemoteDataSource
) {

    fun searchImage(
        searchWord: String,
        page: Int,
        onSuccess: (ImageResponse) -> Unit,
        onFail: (Throwable) -> Unit
    ): Disposable = imageSearchRemoteDataSource.getImageList(
        searchWord,
        page,
        onSuccess,
        onFail
    )
}