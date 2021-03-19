package com.example.android_databinding_practice.ui

import android.view.View
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var _name = "Mai"
    private var _lastName = "Yen"
    private var _likes = 0

    val name = _name
    val lastName = _lastName
    val likes = _likes

    fun onLike(view: View){
        _likes++
    }
}