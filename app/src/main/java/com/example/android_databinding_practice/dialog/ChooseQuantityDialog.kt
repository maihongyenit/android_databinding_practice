package com.example.android_databinding_practice.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.android_databinding_practice.databinding.DialogChooseQuantityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChooseQuantityDialog : DialogFragment() {

    private var binding: DialogChooseQuantityBinding? = null
    private val viewModel: ChooseQuantityDialogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dataBinding = DialogChooseQuantityBinding.inflate(inflater, container, false)
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

    private fun observer(){
        viewModel.closeEvent.observe(viewLifecycleOwner){event ->
            event.getContentIfNotHandled()?.let { needClose ->
                dismiss()
            }
        }

        viewModel.quantityEvent.observe(viewLifecycleOwner){event ->
            event.getContentIfNotHandled()?.let { quantity ->

                dismiss()
            }
        }
    }
}