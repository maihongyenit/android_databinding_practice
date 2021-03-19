package com.example.android_databinding_practice.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android_databinding_practice.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentMainBinding.inflate(inflater, container, false)
        dataBinding.viewModel = viewModel
        binding = dataBinding
        return dataBinding.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}