package com.beok.daumimagesearch.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beok.daumimagesearch.base.BaseRecyclerView
import com.beok.daumimagesearch.data.model.ImagesItem

@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceItem")
fun RecyclerView.replaceItem(item: List<ImagesItem>?) {
    (this.adapter as? BaseRecyclerView.Adapter<Any, *>)?.run {
        replaceItem(item)
        notifyDataSetChanged()
    }
}
