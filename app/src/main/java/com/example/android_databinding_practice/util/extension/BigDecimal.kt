package com.example.android_databinding_practice.util.extension

import java.math.BigDecimal
import java.text.DecimalFormat

fun BigDecimal.getValue(): String {
    val df = DecimalFormat("###,###,###.00")
    return df.format(this)
}