package com.example.android_databinding_practice.ui.product

import androidx.lifecycle.*
import com.example.android_databinding_practice.domain.product.CartRepo
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.ui.product.ProductFragment.Companion.PRODUCT_SERIAL

class ProductViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    productRepo: ProductRepo,
    cartRepo: CartRepo
) : ViewModel() {
    private val _productSerial = savedStateHandle.getLiveData<Int>(PRODUCT_SERIAL)
    private val _quantity = MutableLiveData(cartRepo.getQuantity(_productSerial.value ?: 0))

    val product = _productSerial.map { productRepo.getProduct(it) }
    val quantity: LiveData<Int> = _quantity
}