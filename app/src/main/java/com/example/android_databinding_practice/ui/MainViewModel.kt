package com.example.android_databinding_practice.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_databinding_practice.data.Popular
import com.example.android_databinding_practice.extension.getPopular
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _name = MutableStateFlow("Mai")
    private val _lastName = MutableStateFlow("Yen")
    private val _likes = MutableStateFlow(0)

    private val popular = _likes.map {
        Popular.getPopular(it)
    }.stateIn(viewModelScope, SharingStarted.Lazily, Popular.NORMAL)

    val name = _name.asStateFlow()
    val lastName = _lastName.asStateFlow()
    val likes = _likes.asStateFlow()

    fun onLike(view: View) {
        viewModelScope.launch {
            _likes.value++
            Log.d("MainViewModel", "increate likes: ${_likes.value}")
        }
    }
}