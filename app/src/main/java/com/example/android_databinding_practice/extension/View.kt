package com.example.android_databinding_practice.extension

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

fun View.changeConstraintHeight(progress: Float) {
    val constraintParams = layoutParams as ConstraintLayout.LayoutParams
    constraintParams.matchConstraintPercentHeight = progress
}