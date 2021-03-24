package com.example.android_databinding_practice.ui

import androidx.lifecycle.ViewModel
import com.example.android_databinding_practice.domain.product.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepo: ProductRepo) : ViewModel() {

    val products = productRepo.products

}