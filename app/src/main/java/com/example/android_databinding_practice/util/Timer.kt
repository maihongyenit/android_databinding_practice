package com.example.android_databinding_practice.util

import java.util.*
import java.util.Timer
import javax.inject.Inject

interface MyTimer {

    fun reset()
    fun start(task: TimerTask)
    fun getElapsedTime(): Long
    fun updatePausedTime()
    fun getPausedTime(): Long
    fun resetStartTime()
    fun resetPauseTime()
}

class DefaultTimer : MyTimer {

    companion object {
        private const val TIMER_PERIOD_MS = 100L
    }

    private var startTime = System.currentTimeMillis()
    private var pauseTime = 0L

    private var timer = Timer()

    override fun reset() {
        timer.cancel()
    }

    override fun start(task: TimerTask) {
        timer = Timer()
        timer.scheduleAtFixedRate(task, 0, TIMER_PERIOD_MS)
    }

    override fun getElapsedTime() = System.currentTimeMillis() - startTime

    override fun updatePausedTime() {
        startTime += System.currentTimeMillis() - pauseTime
    }

    override fun getPausedTime(): Long = pauseTime - startTime

    override fun resetPauseTime() {
        pauseTime = System.currentTimeMillis()
    }

    override fun resetStartTime() {
        startTime = System.currentTimeMillis()
    }
}
