package com.example.android_databinding_practice.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_databinding_practice.domain.product.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepo: ProductRepo) : ViewModel() {

    val isRefreshing: LiveData<Boolean> = productRepo.isRefreshingProduct

    val products = productRepo.products

    fun refreshProduct() {
        viewModelScope.launch {
            productRepo.refreshProducts()
        }
    }
}