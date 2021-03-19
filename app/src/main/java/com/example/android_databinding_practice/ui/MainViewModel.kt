package com.example.android_databinding_practice.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.android_databinding_practice.data.Popular
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var _name: String = "Mai"
    private var _lastName: String = "Yen"
    private var _likes: Int by Delegates.observable(0) { _, _, new ->
        _popular = when {
            new > 9 -> Popular.STAR
            new > 4 -> Popular.POPULAR
            else -> Popular.NORMAL
        }
    }
    private var _popular: Popular = Popular.NORMAL

    val name: String = _name
    val lastName: String = _lastName
    val likes: Int = _likes
    val popular: Popular = _popular

    fun onLike(view: View) {
        _likes++
        Log.d("MainViewModel", "increate likes: $likes")
    }
}