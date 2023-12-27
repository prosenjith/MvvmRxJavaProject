package com.example.mvvmrxjavaproject.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmrxjavaproject.base.viewmodel.AppViewModelFactory
import com.example.mvvmrxjavaproject.base.viewmodel.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<ViewModel : BaseViewModel, DataBinding : ViewDataBinding> : Fragment(),
    HasAndroidInjector {

    private lateinit var viewModel: ViewModel
    private lateinit var binding: DataBinding
    protected var baseFragmentCallback: BaseFragmentCallback? = null

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    abstract fun getViewModel(): Class<ViewModel>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        baseFragmentCallback = context as? BaseFragmentCallback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[getViewModel()]
    }
}