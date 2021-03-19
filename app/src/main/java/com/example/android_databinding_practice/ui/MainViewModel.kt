package com.example.android_databinding_practice.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.android_databinding_practice.data.Popular
import com.example.android_databinding_practice.extension.getPopular
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _name = MutableLiveData("Mai")
    private val _lastName = MutableLiveData("Yen")
    private val _likes = MutableLiveData(0)
    private var _popular = _likes.map {
        Popular.getPopular(it)
    }

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes
    val popular: LiveData<Popular> = _popular

    fun onLike(view: View) {
        _likes.postValue((_likes.value ?: 0) + 1)
        Log.d("MainViewModel", "increate likes: ${_likes.value}")
    }
}