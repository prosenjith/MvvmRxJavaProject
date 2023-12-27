package com.example.mvvmrxjavaproject.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmrxjavaproject.base.viewmodel.BaseViewModel
import com.example.mvvmrxjavaproject.data.model.Product
import com.example.mvvmrxjavaproject.data.repository.FakeStoreRepository
import com.example.mvvmrxjavaproject.utils.withScheduler
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: FakeStoreRepository
) : BaseViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        repository.fetchProducts()
            .withScheduler()
            .doOnSubscribe { _shouldShowLoader.value = true }
            .doOnTerminate { _shouldShowLoader.value = false }
            .subscribe({
                _products.value = it
            }, {
                _toastMessage.value = it.localizedMessage
            }).addTo(compositeDisposable)
    }
}