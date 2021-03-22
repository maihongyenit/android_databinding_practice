package com.example.android_databinding_practice.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.extension.changeConstraintHeight

object AnimationDataBindingAdapter {

    @BindingAdapter("progress")
    @JvmStatic
    fun animateProgress(view: View, progress: Float) {
        view.changeConstraintHeight(progress)
    }
}