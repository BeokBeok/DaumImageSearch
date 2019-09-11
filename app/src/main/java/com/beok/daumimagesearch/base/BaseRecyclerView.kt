package com.beok.daumimagesearch.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseRecyclerView {

    open class ViewHolder<VDB : ViewDataBinding>(
        @LayoutRes
        private val layoutRes: Int,
        parent: ViewGroup,
        private val bindingId: Int
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(
                layoutRes,
                parent,
                false
            )
    ) {
        private val binding: VDB = DataBindingUtil.bind(itemView)!!

        fun onBind(item: Any?) {
            binding.setVariable(
                bindingId,
                item
            )
        }

    }

    open class Adapter<A : Any, VDB : ViewDataBinding>(
        @LayoutRes
        private val layoutRes: Int,
        private val bindingId: Int
    ) : RecyclerView.Adapter<ViewHolder<VDB>>() {

        private val item = mutableListOf<A>()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder<VDB> = object : ViewHolder<VDB>(
            layoutRes,
            parent,
            bindingId
        ) {}

        override fun getItemCount(): Int = item.size

        override fun onBindViewHolder(
            holder: ViewHolder<VDB>,
            position: Int
        ) = holder.onBind(item[position])

        fun replaceItem(item: List<A>?) {
            item?.let {
                this.item.clear()
                this.item.addAll(it)
            }
        }
    }

}