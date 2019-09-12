package com.beok.daumimagesearch.data

import com.beok.daumimagesearch.data.model.ImageResponse
import io.reactivex.disposables.Disposable

interface ImageSearchDataSource {

    fun getImageList(
        searchWord: String,
        page: Int,
        onSuccess: (ImageResponse) -> Unit,
        onFail: (Throwable) -> Unit
    ): Disposable
}