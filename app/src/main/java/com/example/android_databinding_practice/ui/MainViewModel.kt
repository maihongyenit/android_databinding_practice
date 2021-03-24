package com.example.android_databinding_practice.ui

import androidx.lifecycle.ViewModel
import com.example.android_databinding_practice.domain.product.ProductRepo

class MainViewModel (private val productRepo: ProductRepo): ViewModel() {

    val products = productRepo.products

}