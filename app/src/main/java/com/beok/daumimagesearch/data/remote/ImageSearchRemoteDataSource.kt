package com.beok.daumimagesearch.data.remote

import com.beok.daumimagesearch.data.ImageSearchDataSource
import com.beok.daumimagesearch.data.model.ImageResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ImageSearchRemoteDataSource(
    private val retrofit: ImageSearchService
) : ImageSearchDataSource {

    override fun getImageList(
        searchWord: String,
        page: Int,
        onSuccess: (ImageResponse) -> Unit,
        onFail: (Throwable) -> Unit
    ): Disposable = retrofit.getImage(searchWord, page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
            onSuccess(it)
        }, {
            onFail(it)
        })
}