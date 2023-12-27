package com.example.mvvmrxjavaproject.data.datasource.fakestore

import com.example.mvvmrxjavaproject.data.model.Product
import com.example.mvvmrxjavaproject.data.network.onResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FakeStoreApi @Inject constructor(private val service: FakeStoreService) {

    fun fetchProducts(): Single<List<Product>> {
        return service.fetchProducts()
            .onResponse()
    }
}