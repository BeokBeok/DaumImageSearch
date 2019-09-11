package com.beok.daumimagesearch.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beok.daumimagesearch.base.BaseRecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("replaceItem")
fun RecyclerView.replaceItem(item: List<Any>?) {
    (this.adapter as? BaseRecyclerView.Adapter<Any, *>)?.run {
        replaceItem(item)
        notifyDataSetChanged()
    }
}
