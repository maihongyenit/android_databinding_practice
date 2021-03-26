package com.example.android_databinding_practice.di

import android.content.SharedPreferences
import com.example.android_databinding_practice.domain.cart.CartRepo
import com.example.android_databinding_practice.domain.cart.CartRepoSharedPreferenceImpl
import com.example.android_databinding_practice.domain.product.ProductRepo
import com.example.android_databinding_practice.domain.product.ProductRepoImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun provideCartRepo(
        prefs: SharedPreferences,
        @CartKey cartKey: String,
        gson: Gson,
        scope: CoroutineScope,
        productRepo: ProductRepo
    ): CartRepo {
        return CartRepoSharedPreferenceImpl(prefs, cartKey, gson, scope, productRepo)
    }

    @Singleton
    @Provides
    fun provideProductRepo(): ProductRepo {
        return ProductRepoImpl()
    }
}