package com.beok.daumimagesearch.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.beok.daumimagesearch.util.GlideWrapper

@BindingAdapter("srcWithGlide")
fun ImageView.srcWithGlide(url: String) {
    GlideWrapper.loadImage(
        this.context,
        url,
        this
    )
}