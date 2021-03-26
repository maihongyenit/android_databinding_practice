package com.example.android_databinding_practice.util

sealed class State<out T> {
    data class Success<T>(val data: T? = null) : State<T>()
    data class Error<T>(val data: T? = null, val throwable: Throwable) : State<T>()
    data class Loading<T>(val data: T? = null) : State<T>()
}

fun <T, R> State<T>.transform(function: (T?) -> R): State<R> {
    return when (this) {
        is State.Success -> State.Success(function(this.data))
        is State.Error -> State.Error(function(this.data), this.throwable)
        is State.Loading -> State.Loading(function(this.data))
    }
}

fun <T> State<T>.getValue(onlySuccess: Boolean = true): T? {
    return if (onlySuccess) {
        when (this) {
            is State.Success -> this.data
            else -> null
        }
    } else {
        when (this) {
            is State.Success -> this.data
            is State.Error -> this.data
            is State.Loading -> this.data
        }
    }
}
