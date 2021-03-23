package com.example.android_databinding_practice.ui.product

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.data.Product
import com.example.android_databinding_practice.extension.getValue

object ProductFragmentBindingAdapter {

    @BindingAdapter("productRatingNum")
    fun setProductRatingNum(tv: TextView, product: Product) {
        val ratingNumStr = product.ratingNumString
        if (tv.text != ratingNumStr) {
            tv.text = ratingNumStr
        }
    }

    @BindingAdapter("productTitle")
    fun setProductTitle(tv: TextView, product: Product) {
        val title = product.title
        if (tv.text != title) {
            tv.text = title
        }
    }

    @BindingAdapter("productPrice")
    fun setProductPrice(tv: TextView, product: Product) {
        val price = if (product.hasSale) product.salePrice else product.price
        val priceStr = price.getValue()
        if (tv.text != priceStr) {
            tv.text = priceStr
        }
    }

    @BindingAdapter("productOldPrice")
    fun setProductOldPrice(tv: TextView, product: Product) {
        if (tv.visibility == View.VISIBLE) {
            val priceStr = product.price.getValue()
            if (tv.text != priceStr) {
                tv.text = priceStr
            }
        }
    }

    @BindingAdapter("productRating")
    fun setProductRating(bar: RatingBar, product: Product) {
        val rating = product.rating.toFloat()
        if (bar.rating != rating) {
            bar.rating = rating
        }
    }
}