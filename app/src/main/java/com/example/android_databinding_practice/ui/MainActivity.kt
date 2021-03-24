package com.example.android_databinding_practice.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.android_databinding_practice.R
import com.example.android_databinding_practice.databinding.ActivityMainBinding
import com.example.android_databinding_practice.ui.product.ProductFragment
import com.example.android_databinding_practice.ui.product.ProductFragment.Companion.PRODUCT_SERIAL
import com.example.android_databinding_practice.ui.products.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: MainActivityFragmentFactory
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()
    }

    fun init() {
        supportFragmentManager.run {
            fragmentFactory = this@MainActivity.fragmentFactory
            beginTransaction()
                .replace(
                    R.id.fragment_container,
                    MainFragment::class.java,
                    null
                )
                .commit()
        }
    }

    fun observer() {
        viewModel.detailProductSerial.observe(this) { event ->
            event.getContentIfNotHandled()?.let { serial ->
                supportFragmentManager.run {
                    beginTransaction()
                        .replace(
                            R.id.fragment_container,
                            ProductFragment::class.java,
                            Bundle().apply { putInt(PRODUCT_SERIAL, serial) }
                        )
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }
}