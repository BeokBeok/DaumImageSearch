package com.beok.daumimagesearch.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beok.daumimagesearch.base.BaseRecyclerView

@BindingAdapter("replaceItem")
fun RecyclerView.replaceItem(item: List<Any>) {
    (this.adapter as? BaseRecyclerView.Adapter<*, *>)?.run {
        replaceItem(item)
        notifyDataSetChanged()
    }
}
