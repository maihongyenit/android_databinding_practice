package com.example.android_databinding_practice.domain.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android_databinding_practice.models.CartItem

class CartRepoSharedPreferenceImpl : CartRepo {

    private val _carts = MutableLiveData(setOf<CartItem>())
    override val carts: LiveData<Set<CartItem>> = _carts

    override fun addToCart(cartItem: CartItem) {
        val set = _carts.value ?: setOf()
        set.contains(cartItem)
            .takeIf { !it }
            ?.let {
                val newSet = set.toMutableSet()
                newSet += cartItem
                _carts.postValue(newSet)
            }
    }

    override fun changeQuantity(cartItem: CartItem, step: Int) {
        val set = _carts.value ?: setOf()
        set.contains(cartItem)
            .takeIf { it }
            ?.let {
                val newSet = set.toMutableSet()
                newSet.remove(cartItem)

                val quantity = (cartItem.quantity + step)
                if (quantity > 0) {
                    newSet += cartItem.copy(quantity = quantity)
                }

                _carts.postValue(newSet)
            }
    }
}