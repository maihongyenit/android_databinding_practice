package com.example.android_databinding_practice.ui

import android.R.attr.key
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.databinding.ActivityMainBinding
import com.example.android_databinding_practice.ui.product.ProductFragment
import com.example.android_databinding_practice.ui.product.ProductFragment.Companion.PRODUCT_SERIAL
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: MainActivityFragmentFactory
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.run {
            fragmentFactory = this@MainActivity.fragmentFactory
            beginTransaction()
                .replace(
                    R.id.fragment_container,
                    ProductFragment::class.java,
                    Bundle().apply { putInt(PRODUCT_SERIAL, 1515611) })
                .commit()
        }
    }
}