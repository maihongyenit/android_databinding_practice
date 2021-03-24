package com.example.android_databinding_practice.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.android_databinding_practice.ui.product.ProductFragment
import com.example.android_databinding_practice.ui.products.MainFragment
import javax.inject.Inject

class MainActivityFragmentFactory @Inject constructor() : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            ProductFragment::class.java.name -> ProductFragment()
            MainFragment::class.java.name -> MainFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}