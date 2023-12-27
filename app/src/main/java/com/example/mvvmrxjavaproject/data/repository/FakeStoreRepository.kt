package com.example.mvvmrxjavaproject.data.repository

import com.example.mvvmrxjavaproject.data.model.Product
import io.reactivex.rxjava3.core.Single

interface FakeStoreRepository {
    fun fetchProducts(): Single<List<Product>>
}