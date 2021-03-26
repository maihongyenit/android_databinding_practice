package com.example.android_databinding_practice.ui.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.example.android_databinding_practice.R

object GlideBindingAdapter {

    @BindingAdapter(value = ["glideListener", "imageResource"], requireAll = false)
    @JvmStatic
    fun setImageResource(
        img: ImageView,
        listener: RequestListener<Drawable>?,
        @DrawableRes resourceId: Int
    ) {
        val option = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(img.context)
            .setDefaultRequestOptions(option)
            .load(resourceId)
            .fitCenter()
            .listener(listener)
            .into(img)
    }
}