package com.beok.daumimagesearch.imagesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beok.daumimagesearch.base.BaseViewModel
import com.beok.daumimagesearch.data.ImageSearchRepository
import com.beok.daumimagesearch.data.model.ImagesItem

class ImageSearchViewModel(
    private val imageSearchRepository: ImageSearchRepository
) : BaseViewModel() {

    private val _imageList = MutableLiveData<List<ImagesItem>>()
    private val _errMsg = MutableLiveData<Throwable>()

    val imageList: LiveData<List<ImagesItem>> get() = _imageList
    val errMsg: LiveData<Throwable> get() = _errMsg

    fun searchImage(searchWord: String) {
        addDisposable(
            imageSearchRepository.searchImage(
                searchWord,
                onSuccess = {
                    _imageList.value = it
                },
                onFail = {
                    _errMsg.value = it
                }
            )
        )
    }
}