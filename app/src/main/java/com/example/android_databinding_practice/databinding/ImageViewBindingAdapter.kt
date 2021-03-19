package com.example.android_databinding_practice.databinding

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.data.Popular
import com.example.android_databinding_practice.extension.getColor
import com.example.android_databinding_practice.extension.getDrawable

object ImageViewBindingAdapter {

    @BindingAdapter("popularIcon")
    @JvmStatic
    fun popularIcon(imageView: ImageView, popular: Popular) {
        val color = popular.getColor(imageView.context)
        val drawable = popular.getDrawable(imageView.context)
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(color))
        imageView.setImageDrawable(drawable)
    }
}