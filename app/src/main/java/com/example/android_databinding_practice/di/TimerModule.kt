package com.example.android_databinding_practice.di

import com.example.android_databinding_practice.util.DefaultTimer
import com.example.android_databinding_practice.util.MyTimer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TimerModule {

    @Provides
    fun provideTimer(): MyTimer = DefaultTimer()
}