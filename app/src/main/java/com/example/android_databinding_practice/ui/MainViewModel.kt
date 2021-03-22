package com.example.android_databinding_practice.ui

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.android_databinding_practice.data.TimerState
import com.example.android_databinding_practice.extension.roundTo
import com.example.android_databinding_practice.util.MyTimer
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

const val TIME_COUNT_DOWN = 10_000L // Milli-seconds

@HiltViewModel
class MainViewModel @Inject constructor(private val timer: MyTimer) : ViewModel() {
    private val _timeLeft = MutableLiveData(TIME_COUNT_DOWN)
    private val _state = MutableLiveData(TimerState.STOPPED)

    val state: LiveData<TimerState> = _state
    val timeLeft: LiveData<Long> = _timeLeft
    val progress: LiveData<Float> = _timeLeft.map {
        val percent = it / TIME_COUNT_DOWN.toFloat()
        percent.roundTo(2)
    }

    fun onButtonClicked(v: View) {
        when (_state.value) {
            TimerState.PAUSED -> pausedToStarted()
            TimerState.STOPPED -> stoppedToStarted()
            TimerState.STARTED -> startedToPaused()
        }

        val task = object : TimerTask() {
            override fun run() {
                if (_state.value == TimerState.STARTED) {
                    val elapsed = timer.getElapsedTime()
                    val newTimeLeft = (TIME_COUNT_DOWN - elapsed).coerceAtLeast(0)
                    _timeLeft.postValue(newTimeLeft)

                    if (newTimeLeft <= 0) {
                        timerFinished()
                    }
                }
            }
        }
        timer.start(task)
    }

    private fun pausedToStarted() {
        _state.postValue(TimerState.STARTED)
        timer.updatePausedTime()
    }

    private fun stoppedToStarted() {
        _state.postValue(TimerState.STARTED)
        timer.resetStartTime()
    }

    private fun startedToPaused() {
        _state.postValue(TimerState.PAUSED)
        timer.resetPauseTime()
    }

    private fun timerFinished() {
        _state.postValue(TimerState.STOPPED)
        _timeLeft.postValue(TIME_COUNT_DOWN)
        timer.reset()
    }
}