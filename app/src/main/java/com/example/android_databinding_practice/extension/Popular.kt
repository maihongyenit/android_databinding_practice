package com.example.android_databinding_practice.extension

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.data.Popular

@ColorInt
fun Popular.getColor(context: Context): Int {
    @ColorRes val colorIdResource = when (this) {
        Popular.NORMAL -> R.color.normal
        Popular.POPULAR -> R.color.popular
        Popular.START -> R.color.star
    }

    return ContextCompat.getColor(context, colorIdResource)
}

fun Popular.getDrawable(context: Context): Drawable? {
    @DrawableRes val drawableIdResource = when (this) {
        Popular.NORMAL -> R.drawable.ic_person_black_96dp
        Popular.POPULAR -> R.drawable.ic_whatshot_black_96dp
        Popular.START -> R.drawable.ic_whatshot_black_96dp
    }

    return ContextCompat.getDrawable(context, drawableIdResource)
}