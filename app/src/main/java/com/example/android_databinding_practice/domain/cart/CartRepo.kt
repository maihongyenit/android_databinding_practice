package com.example.android_databinding_practice.domain.cart

import androidx.lifecycle.LiveData
import com.example.android_databinding_practice.models.CartItem
import com.example.android_databinding_practice.util.State

interface CartRepo {

    val carts: LiveData<State<List<CartItem>?>>

    suspend fun addToCart(cartItem: CartItem)

    suspend fun changeQuantity(cartItem: CartItem, step: Int)
}