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
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes
    private val resourceId: Int
) : Fragment() {

    protected lateinit var binding: VDB
    protected abstract val viewModel: VM
    private val compositeDisposable = CompositeDisposable()

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

    override fun onDestroyView() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
        super.onDestroyView()
    }

    protected fun showSnackbar(
        layout: View,
        msg: String?
    ) = Snackbar.make(
        layout,
        msg?.let { it } ?: "",
        Snackbar.LENGTH_SHORT
    ).show()

    protected fun addDisposable(disposable: Disposable) =
        compositeDisposable.add(disposable)
}