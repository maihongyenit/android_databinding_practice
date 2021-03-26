package com.example.android_databinding_practice.domain.product

import androidx.lifecycle.LiveData
import com.example.android_databinding_practice.data.CartItem

interface CartRepo {

    val carts: LiveData<Set<CartItem>>

    fun addToCart(cartItem: CartItem)

    fun changeQuantity(cartItem: CartItem, step: Int)
}