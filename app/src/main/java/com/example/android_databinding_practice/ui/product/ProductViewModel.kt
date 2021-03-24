package com.example.android_databinding_practice.ui.product

import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.android_databinding_practice.data.Product
import com.example.android_databinding_practice.domain.product.CartRepo
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.extension.zip
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

    val product: LiveData<Product?> = _productSerial.zip(productRepo.products) { serial, product ->
        serial?.let { s ->
            product.find { it.serial == s }
        }
    }

    private val _imageLoaded = MutableLiveData(false)
    val imageLoaded: LiveData<Boolean> = _imageLoaded

    val quantity: LiveData<Int> = _quantity

    val listener = object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            _imageLoaded.postValue(true)
            return false
        }
    }
}