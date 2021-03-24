package com.example.android_databinding_practice.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android_databinding_practice.databinding.FragmentProductBinding
import com.example.android_databinding_practice.dialog.ChooseQuantityDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    companion object {
        const val PRODUCT_SERIAL = "product_serial"
    }

    private var binding: FragmentProductBinding? = null
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = FragmentProductBinding.inflate(inflater, container, false)
        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
        binding = dataBinding
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observer() {
        viewModel.showQuantityDialogEvent.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let { showDialog ->
                if (showDialog) {
                    ChooseQuantityDialog().show(childFragmentManager, null)
                }
            }
        }
    }
}