package com.beok.daumimagesearch.data

interface ImageSearchDataSource {
    fun getImageList(
        searchWord: String,
        onSuccess: (List<ImagesItem>) -> Unit,
        onFail: (Throwable) -> Unit
    )
}