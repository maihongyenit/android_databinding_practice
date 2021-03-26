package com.example.android_databinding_practice.databinding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestListener
import com.example.android_databinding_practice.adapter.ProductsAdapter
import com.example.android_databinding_practice.models.Product
import com.example.android_databinding_practice.extension.formatQuantity
import com.example.android_databinding_practice.extension.getValue

object ProductBindingAdapter {

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

    @BindingAdapter(value = ["productAdapter", "productList"], requireAll = true)
    @JvmStatic
    fun setProductList(v: RecyclerView, adapter: ProductsAdapter, products: List<Product>?) {
        // Initial
        if (v.adapter != adapter) {
            v.adapter = adapter
            if (v.layoutManager == null) {
                v.layoutManager = GridLayoutManager(v.context, 2)
            }
        }

        products?.let {
            v.adapter?.let {
                if (it is ProductsAdapter) {
                    it.refreshList(products)
                }
            }
        }
    }

    @BindingAdapter(value = ["glideListener", "productImageResource"], requireAll = false)
    @JvmStatic
    fun setImageResource(img: ImageView, listener: RequestListener<Drawable>?, product: Product?) {
        product?.let {
            GlideBindingAdapter.setImageResource(img, listener, it.image)
        }
    }
}