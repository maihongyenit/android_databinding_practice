package com.example.android_databinding_practice.extension

/**
 * Convert seconds Int to String
 */
fun Long.toSecondsString(): String {
    val secondLeft = this.toSecond()
    val minutes = secondLeft / 60
    val seconds = secondLeft % 60
    return String.format("%02d:%02d", minutes, seconds)
}
