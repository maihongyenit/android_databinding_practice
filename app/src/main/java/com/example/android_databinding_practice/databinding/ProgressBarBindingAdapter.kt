package com.example.android_databinding_practice.databinding

import android.content.res.ColorStateList
import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.data.Popular
import com.example.android_databinding_practice.extension.getColor
import com.example.android_databinding_practice.util.Constant

object ProgressBarBindingAdapter {

    @BindingAdapter("progressTint")
    @JvmStatic
    fun tintPopular(progressBar: ProgressBar, popular: Popular) {
        val color = popular.getColor(progressBar.context)
        progressBar.progressTintList = ColorStateList.valueOf(color)
    }

    @BindingAdapter(value = ["progress", "android:max"])
    @JvmStatic
    fun setProgress(progressBar: ProgressBar, progress: Int, maxProgress: Int) {
        progressBar.progress =
            (progress * maxProgress / Constant.POPULAR_STEP).coerceAtMost(maxProgress)
    }

    @BindingAdapter("hideIfZero")
    @JvmStatic
    fun hideIfZero(progressBar: ProgressBar, progress: Int) {
        progressBar.visibility = if (progress <= 0) View.GONE else View.VISIBLE
    }
}