package com.beok.daumimagesearch.data.remote

import com.beok.daumimagesearch.data.ImageSearchDataSource
import com.beok.daumimagesearch.data.ImagesItem

class ImageSearchRemoteDataSource : ImageSearchDataSource {

    override fun getImageList(
        searchWord: String,
        onSuccess: (List<ImagesItem>) -> Unit,
        onFail: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}