package com.example.android_databinding_practice.domain.product

interface CartRepo {

    fun getQuantity(serial: Int): Int
}