package com.beok.daumimagesearch.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes
    private val resourceId: Int
) : Fragment() {

    protected lateinit var binding: VDB
    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            resourceId,
            container,
            false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    protected fun showSnackbar(
        layout: View,
        msg: String?
    ) = Snackbar.make(
        layout,
        msg?.let { it } ?: "",
        Snackbar.LENGTH_SHORT
    ).show()
}