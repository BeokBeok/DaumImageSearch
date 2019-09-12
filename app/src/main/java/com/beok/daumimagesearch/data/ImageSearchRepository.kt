package com.beok.daumimagesearch.data

import com.beok.daumimagesearch.data.model.ImageResponse
import io.reactivex.disposables.Disposable

class ImageSearchRepository(
    private val imageSearchRemoteDataSource: ImageSearchDataSource
) : ImageSearchDataSource {

    override fun getImageList(
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