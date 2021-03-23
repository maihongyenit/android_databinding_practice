package com.example.android_databinding_practice.ui.product

import androidx.lifecycle.*
import com.example.android_databinding_practice.domain.product.CartRepo
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.ui.product.ProductFragment.Companion.PRODUCT_SERIAL
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val productRepo: ProductRepo,
    private val cartRepo: CartRepo
) : ViewModel() {
    private val _productSerial: LiveData<Int?> = savedStateHandle.getLiveData(PRODUCT_SERIAL, null)
    private val _quantity = MutableLiveData(cartRepo.getQuantity(_productSerial.value ?: 0))

    val product = _productSerial.map { serial ->
        serial?.let { productRepo.getProduct(it) }
    }
    val quantity: LiveData<Int> = _quantity
}