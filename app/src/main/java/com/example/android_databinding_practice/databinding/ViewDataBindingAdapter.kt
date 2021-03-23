package com.example.android_databinding_practice.databinding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewDataBindingAdapter {

    @BindingAdapter("visible")
    @JvmStatic fun setVisible(v: View, visible: Boolean) {
        val visiblity = if (visible) View.VISIBLE else View.GONE
        if (v.visibility != visiblity) {
            v.visibility = visiblity
        }
    }
}