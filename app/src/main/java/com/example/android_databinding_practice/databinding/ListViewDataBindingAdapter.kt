package com.example.android_databinding_practice.databinding

import android.widget.AdapterView
import android.widget.ListView
import androidx.databinding.BindingAdapter

object ListViewDataBindingAdapter {

    @BindingAdapter("onItemClickListener")
    @JvmStatic
    fun setListViewItemClickListener(lv: ListView, listener: AdapterView.OnItemClickListener) {
        lv.onItemClickListener = listener
    }
}