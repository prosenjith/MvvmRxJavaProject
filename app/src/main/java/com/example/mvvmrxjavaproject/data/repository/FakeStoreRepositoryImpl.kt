package com.example.mvvmrxjavaproject.data.repository

import android.content.Context
import com.example.mvvmrxjavaproject.data.datasource.fakestore.FakeStoreApi
import com.example.mvvmrxjavaproject.data.model.Product
import com.example.mvvmrxjavaproject.data.network.onException
import com.example.mvvmrxjavaproject.di.qualifier.ApplicationContext
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FakeStoreRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val api: FakeStoreApi
) : FakeStoreRepository {
    override fun fetchProducts(): Single<List<Product>> {
        return api.fetchProducts()
            .onException(context)
    }
}