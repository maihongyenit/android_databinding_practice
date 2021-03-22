package com.example.android_databinding_practice.databinding

import android.widget.Button
import androidx.databinding.BindingAdapter
import com.example.android_databinding_practice.data.TimerState

object ButtonBindingAdapter {

    @BindingAdapter("btnTextState")
    @JvmStatic fun textButtonState(button: Button, state: TimerState) {
        button.text = when (state) {
            TimerState.STOPPED -> "Start"
            TimerState.STARTED -> "Pause"
            TimerState.PAUSED -> "Start"
        }
    }
}