package com.example.android_databinding_practice.extension

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.data.Popular
import com.example.android_databinding_practice.util.Constant

@ColorInt
fun Popular.getColor(context: Context): Int {
    @ColorRes val colorIdResource = when (this) {
        Popular.NORMAL -> R.color.normal
        Popular.POPULAR -> R.color.popular
        Popular.STAR -> R.color.star
    }

    return ContextCompat.getColor(context, colorIdResource)
}

fun Popular.getDrawable(context: Context): Drawable? {
    @DrawableRes val drawableIdResource = when (this) {
        Popular.NORMAL -> R.drawable.ic_person_black_96dp
        Popular.POPULAR -> R.drawable.ic_whatshot_black_96dp
        Popular.STAR -> R.drawable.ic_whatshot_black_96dp
    }

    return ContextCompat.getDrawable(context, drawableIdResource)
}

fun Popular.Companion.getPopular(like: Int): Popular {
    return when {
        like >= Constant.POPULAR_STEP * 2 -> Popular.STAR
        like >= Constant.POPULAR_STEP * 1 -> Popular.POPULAR
        else -> Popular.NORMAL
    }
}