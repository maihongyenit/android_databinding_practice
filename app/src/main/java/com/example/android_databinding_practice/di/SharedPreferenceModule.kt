package com.example.android_databinding_practice.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @CartKey
    @Provides
    fun provideCartKey(): String {
        return "shopping_cart"
    }
}