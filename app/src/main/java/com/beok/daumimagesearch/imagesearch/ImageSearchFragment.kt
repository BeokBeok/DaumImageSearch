package com.beok.daumimagesearch.imagesearch


import android.os.Bundle
import androidx.lifecycle.Observer
import com.beok.daumimagesearch.BR
import com.beok.daumimagesearch.R
import com.beok.daumimagesearch.base.BaseFragment
import com.beok.daumimagesearch.base.BaseRecyclerView
import com.beok.daumimagesearch.common.TextWatcher
import com.beok.daumimagesearch.data.model.ImagesItem
import com.beok.daumimagesearch.databinding.FragmentImageSearchBinding
import com.beok.daumimagesearch.databinding.RvImageSearchItemBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class ImageSearchFragment : BaseFragment<FragmentImageSearchBinding, ImageSearchViewModel>(
    R.layout.fragment_image_search
) {

    override val viewModel by viewModel<ImageSearchViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        binding.vm = viewModel
        setTextChangedListener()
        setObserve()
    }

    private fun initRecyclerView() {
        binding.rvContent.run {
            setHasFixedSize(true)
            adapter = object : BaseRecyclerView.Adapter<List<ImagesItem>, RvImageSearchItemBinding>(
                R.layout.rv_image_search_item,
                BR.imageList
            ) {}
        }
    }

    private fun setTextChangedListener() {
        addDisposable(
            Observable.create<CharSequence> { emitter ->
                binding.etSearch.addTextChangedListener(object : TextWatcher() {
                    override fun onTextChanged(
                        char: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        char?.let {
                            emitter.onNext(it)
                        }
                    }
                })
            }.debounce(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    binding.vm?.searchImage(it.toString())
                }
        )
    }

    private fun setObserve() {
        binding.vm?.errMsg?.observe(
            this,
            Observer {
                showSnackbar(
                    binding.clMain,
                    it.message
                )
            }
        )
    }
}