package com.example.android_databinding_practice.models

import java.math.BigDecimal

data class Product(
    val title: String,
    val description: String,
    val image: Int,
    val price: BigDecimal,
    val salePrice: BigDecimal,
    val ratingNum: Int,
    val rating: BigDecimal,
    val serial: Int
) {
    val hasSale = salePrice > 0.toBigDecimal()
    val ratingNumString = "($ratingNum)"
}
