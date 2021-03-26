package com.example.android_databinding_practice.domain.product

import androidx.lifecycle.LiveData
import com.example.android_databinding_practice.models.Product

interface ProductRepo {

    val products: LiveData<List<Product>>

    val isRefreshingProduct: LiveData<Boolean>

    suspend fun refreshProducts()
}