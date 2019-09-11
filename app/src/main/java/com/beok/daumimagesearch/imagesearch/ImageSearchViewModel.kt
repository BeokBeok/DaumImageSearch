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
    private val _isLoading = MutableLiveData<Boolean>()

    val imageList: LiveData<List<ImagesItem>> get() = _imageList
    val errMsg: LiveData<Throwable> get() = _errMsg
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun searchImage(searchWord: String) {
        if (searchWord.isEmpty()) {
            setEmpty()
        } else {
            _isLoading.value = true
            addDisposable(
                imageSearchRepository.searchImage(
                    searchWord,
                    onSuccess = {
                        _isLoading.value = false
                        if (it.isEmpty()) setEmpty()
                        else _imageList.value = it
                    },
                    onFail = {
                        _isLoading.value = false
                        _errMsg.value = it
                    }
                )
            )
        }
    }

    private fun setEmpty() {
        _imageList.value = listOf()
        _errMsg.value = IllegalStateException("검색 결과가 없습니다.")
    }
}