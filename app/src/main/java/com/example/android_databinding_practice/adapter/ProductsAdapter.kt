package com.example.android_databinding_practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.android_databinding_practice.BR
import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.data.Product

class ProductsAdapter constructor(products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.BindingHolder>() {

    class BindingHolder constructor(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val products = mutableListOf<Product>()

    init {
        this.products += products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_product,
            parent,
            false
        )
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val product = products[position]
        holder.binding.setVariable(BR.product, product)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun refreshList(products: List<Product>) {
        this.products.clear()
        this.products += products
        notifyDataSetChanged()
    }
}