package com.example.android_databinding_practice.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

fun <L1, L2, T> LiveData<L1>.zip(
    other: LiveData<L2>,
    block: (upperStream1: L1, upperStream2: L2) -> T
): LiveData<T> {
    var value1: L1? = null
    var value2: L2? = null
    val mediatorLiveData = MediatorLiveData<T>()

    fun emit() {
        val x1 = value1
        val x2 = value2
        if (x1 != null && x2 != null) {
            val value = block(x1, x2)
            value?.let { mediatorLiveData.postValue(it) }
        }
    }

    mediatorLiveData.addSource(this) {
        value1 = it
        emit()
    }
    mediatorLiveData.addSource(other) {
        value2 = it
        emit()
    }
    return mediatorLiveData
}