package com.example.android_databinding_practice.util.delegate

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.example.android_databinding_practice.util.livedata.SharedPreferenceLiveDataString
import kotlinx.coroutines.CoroutineScope
import kotlin.properties.ReadOnlyProperty

fun SharedPreferences.stringLiveData(
    key: String,
    defValue: String,
    scope: CoroutineScope
): ReadOnlyProperty<Any?, MutableLiveData<String>> {
    return ReadOnlyProperty { _, _ ->
        SharedPreferenceLiveDataString(this, key, defValue, scope)
    }
}
