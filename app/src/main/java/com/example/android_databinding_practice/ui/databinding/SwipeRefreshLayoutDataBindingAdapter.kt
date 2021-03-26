package com.example.android_databinding_practice.ui.databinding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

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
}