package com.example.android_databinding_practice.databinding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.extension.toSecondsString

object TextViewBindingAdapter {

    @BindingAdapter("milliSecondLeft")
    @JvmStatic
    fun timeLeft(tv: TextView, milliSecondLeft: Long) {
        tv.text = milliSecondLeft.toSecondsString()
    }
}