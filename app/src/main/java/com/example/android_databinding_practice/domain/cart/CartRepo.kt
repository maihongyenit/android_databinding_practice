package com.example.android_databinding_practice.domain.cart

import androidx.lifecycle.LiveData
import com.example.android_databinding_practice.models.CartItem

interface CartRepo {

    val carts: LiveData<List<CartItem>>

    suspend fun addToCart(cartItem: CartItem)

    suspend fun changeQuantity(cartItem: CartItem, step: Int)
}