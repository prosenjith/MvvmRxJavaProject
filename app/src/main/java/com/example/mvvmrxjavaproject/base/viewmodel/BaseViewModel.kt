package com.example.mvvmrxjavaproject.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    protected val _shouldShowLoader = SingleLiveEvent<Boolean>()
    val shouldShowLoader: LiveData<Boolean> = _shouldShowLoader

    protected val _toastMessage = SingleLiveEvent<String>()
    val toastMessage: LiveData<String> = _toastMessage

    protected val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}