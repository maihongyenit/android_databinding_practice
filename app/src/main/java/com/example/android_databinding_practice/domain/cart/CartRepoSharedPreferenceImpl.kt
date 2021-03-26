package com.example.android_databinding_practice.domain.cart

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.models.CartItem
import com.example.android_databinding_practice.models.CartItemLocal
import com.example.android_databinding_practice.models.toCartItems
import com.example.android_databinding_practice.models.toLocals
import com.example.android_databinding_practice.util.State
import com.example.android_databinding_practice.util.delegate.stringLiveData
import com.example.android_databinding_practice.util.extension.fromJson
import com.example.android_databinding_practice.util.extension.zip
import com.example.android_databinding_practice.util.getValue
import com.example.android_databinding_practice.util.transform
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Just test for:
 * - SharedPreference LiveData
 * - zip & map LiveData in background use coroutine
 */
//TODO: Implement zip & map in background
class CartRepoSharedPreferenceImpl constructor(
    private val prefs: SharedPreferences,
    private val cartKey: String,
    private val gson: Gson,
    private val scope: CoroutineScope,
    private val productRepo: ProductRepo
) : CartRepo {

    private val _cartGsonStr by prefs.stringLiveData(cartKey, "", scope)
    private val _cartItemsLocal = _cartGsonStr.map { state ->
        state.transform { str ->
            str?.run {
                gson.fromJson<List<CartItemLocal>>(this)
            }
        }
    }
    override val carts: LiveData<State<List<CartItem>?>> =
        _cartItemsLocal.zip(productRepo.products) { state, products ->
            state.transform { cartLocals ->
                cartLocals?.run {
                    toCartItems(products)
                }
            }
        }

    override suspend fun addToCart(cartItem: CartItem) {
        scope.launch {
            _cartGsonStr.emitLoading()
            val list = carts.value?.getValue() ?: listOf()
            if (!list.contains(cartItem)) {
                val newList = list.toMutableList().apply { add(cartItem) }
                val localList = newList.toLocals()
                val newCartStr = gson.toJson(localList)
                _cartGsonStr.setValueToPreference(newCartStr)
            }
        }
    }

    override suspend fun changeQuantity(cartItem: CartItem, step: Int) {
        scope.launch {
            _cartGsonStr.emitLoading()
            val list = carts.value?.getValue() ?: listOf()
            if (list.contains(cartItem)) {
                val newList = list.toMutableList().apply { remove(cartItem) }
                val quantity = cartItem.quantity + step
                if (quantity > 0) {
                    newList += cartItem.copy(quantity = quantity)
                }

                val localList = newList.toLocals()
                val newStr = gson.toJson(localList)
                _cartGsonStr.setValueToPreference(newStr)
            }
        }
    }
}