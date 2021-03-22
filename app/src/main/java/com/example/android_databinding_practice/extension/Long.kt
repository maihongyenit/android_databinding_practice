package com.example.android_databinding_practice.extension

/**
 * Convert milli-seconds to seconds
 */
fun Long.toSecond(): Int {
    return (this / 1000).toInt()
}