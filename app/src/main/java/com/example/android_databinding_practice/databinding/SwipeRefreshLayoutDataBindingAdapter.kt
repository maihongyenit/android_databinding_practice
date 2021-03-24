package com.example.android_databinding_practice.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.data.Product

object SwipeRefreshLayoutDataBindingAdapter {

    @BindingAdapter("refreshing")
    @JvmStatic
    fun setRefreshing(layout: SwipeRefreshLayout, isRefreshing: Boolean?) {
        isRefreshing?.let {
            if (layout.isRefreshing != isRefreshing) {
                layout.isRefreshing = isRefreshing
            }
        }
    }

    @BindingAdapter("onRefresh")
    @JvmStatic
    fun setOnRefreshListener(
        layout: SwipeRefreshLayout,
        listener: SwipeRefreshLayout.OnRefreshListener
    ) {
        layout.setOnRefreshListener(listener)
    }

    @BindingAdapter(value = ["glideListener", "productImageResource"], requireAll = false)
    @JvmStatic
    fun setImageResource(img: ImageView, listener: RequestListener<Drawable>?, product: Product?) {
        product?.let {
            GlideBindingAdapter.setImageResource(img, listener, it.image)
        }
    }
}