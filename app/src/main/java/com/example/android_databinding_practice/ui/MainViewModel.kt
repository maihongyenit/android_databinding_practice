package com.example.android_databinding_practice.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.extension.filterNotNull
import com.example.android_databinding_practice.util.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val productRepo: ProductRepo) : ViewModel() {

    val isRefreshing: LiveData<Boolean> = productRepo.isRefreshingProduct

    private val _detailProductSerial = MutableLiveData(SingleEvent.createOrNull<Int>())
    val detailProductSerial: LiveData<SingleEvent<Int>> = _detailProductSerial.filterNotNull()

    val products = productRepo.products

    fun refreshProduct() {
        viewModelScope.launch {
            productRepo.refreshProducts()
        }
    }

    fun onItemClick(serial: Int) {
        _detailProductSerial.postValue(SingleEvent(serial))
    }
}