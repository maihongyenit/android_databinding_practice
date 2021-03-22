package com.example.android_databinding_practice.extension

import kotlin.math.pow
import kotlin.math.roundToInt

fun Float.roundTo(numFractionDigits: Int): Float {
    val factor: Float = 10f.pow(numFractionDigits)
    return (this * factor).roundToInt() / factor
}