package com.example.mvvmrxjavaproject.data.datasource.fakestore

import com.example.mvvmrxjavaproject.data.model.Product
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface FakeStoreService {

    @GET("/products")
    fun fetchProducts(): Single<Response<List<Product>>>
}