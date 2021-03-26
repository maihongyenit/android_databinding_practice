package com.example.android_databinding_practice.models

data class CartItemLocal(val serial: Int, val quantity: Int)

fun CartItemLocal.toCartItem(products: List<Product>): CartItem? {
    return products
        .find { it.serial == this.serial }
        ?.let { product -> CartItem(product, this.quantity) }
}

fun List<CartItemLocal>.toCartItems(products: List<Product>): List<CartItem> {
    return mapNotNull { it.toCartItem(products) }
}