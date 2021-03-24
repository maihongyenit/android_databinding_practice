package com.example.android_databinding_practice.ui.product

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.data.Product
import com.example.android_databinding_practice.extension.formatQuantity
import com.example.android_databinding_practice.extension.getValue

object ProductFragmentBindingAdapter {

    @BindingAdapter("productRatingNum")
    @JvmStatic
    fun setProductRatingNum(tv: TextView, product: Product?) {
        product
            ?.takeIf { tv.text != it.ratingNumString }
            ?.let { tv.text = it.ratingNumString }
    }

    @BindingAdapter("productTitle")
    @JvmStatic
    fun setProductTitle(tv: TextView, product: Product?) {
        product
            ?.takeIf { tv.text != it.title }
            ?.let { tv.text = it.title }
    }

    @BindingAdapter("productPrice")
    @JvmStatic
    fun setProductPrice(tv: TextView, product: Product?) {
        product?.run {
            val priceStr = (if (hasSale) salePrice else price).getValue()
            if (tv.text != priceStr) {
                tv.text = priceStr
            }
        }
    }

    @BindingAdapter("productOldPrice")
    @JvmStatic
    fun setProductOldPrice(tv: TextView, product: Product?) {
        product?.run {
            if (tv.visibility == View.VISIBLE) {
                val priceStr = price.getValue()
                if (tv.text != priceStr) {
                    tv.text = priceStr
                }
            }
        }
    }

    @BindingAdapter("productRating")
    @JvmStatic
    fun setProductRating(bar: RatingBar, product: Product?) {
        product?.run {
            val rating = product.rating.toFloat()
            if (bar.rating != rating) {
                bar.rating = rating
            }
        }
    }

    @BindingAdapter("productQuantity")
    @JvmStatic
    fun setProductQuantity(tv: TextView, quantity: Int?) {
        quantity
            ?.formatQuantity()
            ?.takeIf { tv.text != it }
            ?.let { tv.text = it }
    }

    @BindingAdapter("productSaleVisible")
    @JvmStatic
    fun setProductSaleVisible(v: View, product: Product?) {

        fun setVisible(view: View, visibility: Int) {
            v.visibility
                .takeIf { it != visibility }
                ?.let { v.visibility = visibility }
        }

        if (product == null) {
            setVisible(v, View.GONE)
        } else {
            val visible = if (product.hasSale) View.VISIBLE else View.GONE
            setVisible(v, visible)
        }
    }
}