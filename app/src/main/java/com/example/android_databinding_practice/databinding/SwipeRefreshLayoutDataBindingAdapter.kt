package com.example.android_databinding_practice.databinding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
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

    @BindingAdapter("productImageResource")
    @JvmStatic
    fun setImageResource(img: ImageView, product: Product?) {
        product?.let {
            GlideBindingAdapter.setImageResource(img, it.image)
        }
    }
}