package com.example.android_databinding_practice.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.android_databinding_practice.adapter.ProductsAdapter
import com.example.android_databinding_practice.databinding.FragmentMainBinding
import com.example.android_databinding_practice.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val mainViewModel: MainViewModel by activityViewModels()
    private val adapter: ProductsAdapter by lazy {
        ProductsAdapter(emptyList()) { mainViewModel.onItemClick(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentMainBinding.inflate(inflater, container, false)
        dataBinding.mainViewModel = mainViewModel
        dataBinding.adapter = adapter
        dataBinding.lifecycleOwner = viewLifecycleOwner
        binding = dataBinding
        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}