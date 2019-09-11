package com.beok.daumimagesearch.imagesearch


import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.beok.daumimagesearch.BR
import com.beok.daumimagesearch.R
import com.beok.daumimagesearch.base.BaseFragment
import com.beok.daumimagesearch.base.BaseRecyclerView
import com.beok.daumimagesearch.data.model.ImagesItem
import com.beok.daumimagesearch.databinding.FragmentImageSearchBinding
import com.beok.daumimagesearch.databinding.RvImageSearchItemBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ImageSearchFragment : BaseFragment<FragmentImageSearchBinding, ImageSearchViewModel>(
    R.layout.fragment_image_search
) {

    override val viewModel by viewModel<ImageSearchViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vm = viewModel
        initRecyclerView()
        setKeypadEditorActionListener()
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

    private fun setKeypadEditorActionListener() {
        binding.etSearchBar.run {
            imeOptions = EditorInfo.IME_ACTION_DONE
            setOnEditorActionListener { textView, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    binding.vm?.searchImage(textView.text.toString())
                    false
                } else {
                    true
                }
            }
        }
    }
}