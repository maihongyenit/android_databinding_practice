package com.example.android_databinding_practice.databinding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android_databinding_practice.R

object GlideBindingAdapter {

    @BindingAdapter("imageResource")
    @JvmStatic
    fun setImageResource(img: ImageView, @DrawableRes resourceId: Int) {
        val option = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(img.context)
            .setDefaultRequestOptions(option)
            .load(resourceId)
            .fitCenter()
            .into(img)
    }
}