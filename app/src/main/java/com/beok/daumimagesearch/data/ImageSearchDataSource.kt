package com.beok.daumimagesearch.data

import com.beok.daumimagesearch.data.model.ImagesItem

interface ImageSearchDataSource {

    fun getImageList(
        searchWord: String,
        onSuccess: (List<ImagesItem>) -> Unit,
        onFail: (Throwable) -> Unit
    )
}