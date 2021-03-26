package com.example.android_databinding_practice.domain.cart

import android.content.SharedPreferences
import androidx.lifecycle.map
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.models.CartItem
import com.example.android_databinding_practice.models.CartItemLocal
import com.example.android_databinding_practice.util.delegate.stringLiveData
import com.example.android_databinding_practice.util.extension.fromJson
import com.example.android_databinding_practice.util.extension.zip
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CartRepoSharedPreferenceImpl constructor(
    private val prefs: SharedPreferences,
    private val cartKey: String,
    private val gson: Gson,
    private val scope: CoroutineScope,
    private val productRepo: ProductRepo
) : CartRepo {

    private val _gsonStr by prefs.stringLiveData(cartKey, "", scope)
    private val _cartItemsLocal = _gsonStr.map {
        gson.fromJson<List<CartItemLocal>>(it)
    }
    override val carts = _cartItemsLocal.zip(productRepo.products) { itemLocal, products ->
        itemLocal
            .mapNotNull { (serial, quantity) ->
                val product = products.find { it.serial == serial }
                product?.let { CartItem(it, quantity) }
            }
    }

    override suspend fun addToCart(cartItem: CartItem) {
        scope.launch {
            val list = carts.value ?: listOf()
            if (!list.contains(cartItem)) {
                val newList = list.toMutableList().apply { add(cartItem) }
                val localList = newList.map { CartItemLocal(it.product.serial, it.quantity) }
                val newStr = gson.toJson(localList)
                _gsonStr.postValue(newStr)
            }
        }
    }

    override suspend fun changeQuantity(cartItem: CartItem, step: Int) {
        scope.launch {
            val list = carts.value ?: listOf()
            if (list.contains(cartItem)) {
                val newList = list.toMutableList().apply { remove(cartItem) }
                val quantity = cartItem.quantity + step
                if (quantity > 0) {
                    newList += cartItem.copy(quantity = quantity)
                }

                val localList = newList.map { CartItemLocal(it.product.serial, it.quantity) }
                val newStr = gson.toJson(localList)
                _gsonStr.postValue(newStr)
            }
        }
    }
}