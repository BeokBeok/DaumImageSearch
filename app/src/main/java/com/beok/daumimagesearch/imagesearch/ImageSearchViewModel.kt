package com.beok.daumimagesearch.imagesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beok.daumimagesearch.base.BaseViewModel
import com.beok.daumimagesearch.data.ImageSearchDataSource
import com.beok.daumimagesearch.data.model.ImagesItem

class ImageSearchViewModel(
    private val imageSearchRepository: ImageSearchDataSource
) : BaseViewModel() {

    private val _searchedList = MutableLiveData<List<ImagesItem>>()
    private val _errMsg = MutableLiveData<Throwable>()
    private val _isLoading = MutableLiveData<Boolean>()
    private val _documents = mutableListOf<ImagesItem>()

    private var _page = 1
    private var _isEnd = false

    val imageList: LiveData<List<ImagesItem>> get() = _searchedList
    val errMsg: LiveData<Throwable> get() = _errMsg
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun searchImage(searchWord: String) {
        clearList()
        requestImageSearch(searchWord)
    }

    fun searchNextImage(searchWord: String) {
        if (_isEnd) return
        _page++
        requestImageSearch(searchWord)
    }

    private fun clearList() {
        _page = 1
        _isEnd = false
        _documents.clear()
        _searchedList.value = _documents
    }

    private fun requestImageSearch(searchWord: String) {
        if (searchWord.isEmpty()) {
            clearList()
            _errMsg.value = IllegalStateException("검색어가 없습니다.")
            return
        }
        _isLoading.value = true
        addDisposable(
            imageSearchRepository.getImageList(
                searchWord,
                _page,
                onSuccess = {
                    _isLoading.value = false
                    if (it.documents.isEmpty()) {
                        _errMsg.value = IllegalStateException("검색 결과가 없습니다.")
                    } else {
                        _documents.addAll(it.documents)
                        _searchedList.value = _documents
                        _isEnd = it.meta.isEnd
                    }
                },
                onFail = {
                    _isLoading.value = false
                    _errMsg.value = it
                }
            )
        )
    }
}