package com.example.android_databinding_practice.databinding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewDataBindingAdapter {

    @BindingAdapter("visibleGone")
    @JvmStatic
    fun setVisibleGone(v: View, visible: Boolean) {
        val visibility = if (visible) View.VISIBLE else View.GONE
        if (v.visibility != visibility) {
            v.visibility = visibility
        }
    }

    @BindingAdapter("visibleInvisible")
    @JvmStatic
    fun setVisibleInvisible(v: View, visible: Boolean) {
        val visibility = if (visible) View.VISIBLE else View.INVISIBLE
        if (v.visibility != visibility) {
            v.visibility = visibility
        }
    }
}