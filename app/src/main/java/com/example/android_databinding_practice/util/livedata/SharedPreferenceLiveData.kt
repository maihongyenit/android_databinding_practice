package com.example.android_databinding_practice.util.livedata

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_databinding_practice.util.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Wrapper class for [SharedPreferences] work with [MutableLiveData] to provide stream.
 * Note: Because many source can change value of [key] so must use this class with [key] like singleton,
 * @param T Type of data to save in [SharedPreferences]
 */
abstract class SharedPreferenceLiveData<T>(
    private val prefs: SharedPreferences,
    private val key: String,
    private val defValue: T,
    private val scope: CoroutineScope
) : LiveData<State<T>>() {

    private var _cachedValue: T? = null

    protected abstract fun getPreferencesValue(
        prefs: SharedPreferences,
        key: String,
        defValue: T
    ): T

    protected abstract fun setPreferencesValue(
        prefs: SharedPreferences,
        key: String,
        value: T
    )

    override fun onActive() {
        super.onActive()
        // Observers is active, get lasted value and dispatch async
        scope.launch {
            emitLoading()
            getPreferencesValue(prefs, key, defValue).let {
                _cachedValue = it
                super.postValue(State.Success(it))
            }
        }
    }

    fun emitLoading() {
        super.postValue(State.Loading(_cachedValue))
    }

    fun setValueToPreference(newValue: T) {
        scope.launch {
            emitLoading()
            newValue.let {
                setPreferencesValue(prefs, key, it)
                _cachedValue = it
                super.postValue(State.Success(it))
            }
        }
    }
}

/**
 * SharedPreference LiveData class for String
 */
class SharedPreferenceLiveDataString(
    prefs: SharedPreferences,
    key: String,
    defValue: String,
    scope: CoroutineScope
) : SharedPreferenceLiveData<String>(prefs, key, defValue, scope) {

    override fun getPreferencesValue(
        prefs: SharedPreferences,
        key: String,
        defValue: String
    ): String {
        return prefs.getString(key, defValue) ?: defValue
    }

    override fun setPreferencesValue(
        prefs: SharedPreferences,
        key: String,
        value: String
    ) {
        prefs.edit { putString(key, value) }
    }
}
