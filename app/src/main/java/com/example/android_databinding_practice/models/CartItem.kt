package com.example.android_databinding_practice.models

data class CartItem(val product: Product, val quantity: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CartItem

        if (product != other.product) return false
        if (quantity != other.quantity) return false

        return true
    }

    override fun hashCode(): Int {
        return product.hashCode()
    }
}
