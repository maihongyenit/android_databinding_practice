package com.example.android_databinding_practice.di

import com.example.android_databinding_practice.domain.cart.CartRepo
import com.example.android_databinding_practice.domain.cart.CartRepoSharedPreferenceImpl
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.domain.product.ProductRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideCartRepo(): CartRepo {
        return CartRepoSharedPreferenceImpl()
    }

    @Singleton
    @Provides
    fun provideProductRepo(): ProductRepo {
        return ProductRepoImpl()
    }
}