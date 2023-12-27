package com.example.mvvmrxjavaproject.base.activity

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmrxjavaproject.base.fragment.BaseFragmentCallback
import com.example.mvvmrxjavaproject.base.viewmodel.AppViewModelFactory
import com.example.mvvmrxjavaproject.base.viewmodel.BaseViewModel
import com.example.mvvmrxjavaproject.utils.ConnectivityLiveData
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<ViewModel : BaseViewModel, DataBinding : ViewDataBinding> :
    AppCompatActivity(), BaseFragmentCallback, HasAndroidInjector {

    protected lateinit var viewModel: ViewModel
    private lateinit var binding: DataBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    @Inject
    lateinit var internetConnectivityLiveData: ConnectivityLiveData

    abstract fun getViewModel(): Class<ViewModel>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewModel()
        initDataBinding()
        observeData()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[getViewModel()]
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this
    }

    private fun observeData() {
        internetConnectivityLiveData.observe(this) {
            Log.e("TAG", "isInternetOn: $it")
        }
        viewModel.shouldShowLoader.observe(this) {
            Log.e("TAG", "observeData: shouldShowLoader -> $it")
        }
        viewModel.toastMessage.observe(this) {
            Log.e("TAG", "observeData: $it")
        }
    }
}