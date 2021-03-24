package com.example.android_databinding_practice.dialog

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_databinding_practice.extension.filterNotNull
import com.example.android_databinding_practice.util.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseQuantityDialogViewModel @Inject constructor() : ViewModel() {

    private val _closeEvent = MutableLiveData(SingleEvent.createOrNull<Boolean>())
    val closeEvent: LiveData<SingleEvent<Boolean>> = _closeEvent.filterNotNull()

    private val _quantityEvent = MutableLiveData(SingleEvent.createOrNull<Int>())
    val quantityEvent = _quantityEvent.filterNotNull()

    fun onCloseClick() {
        _closeEvent.postValue(SingleEvent(true))
    }

    fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, id: Long) {
        val quantity = (adapterView.getItemAtPosition(position) as? String)?.toIntOrNull() ?: 1
        _quantityEvent.postValue(SingleEvent(quantity))
    }
}