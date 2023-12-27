package com.example.mvvmrxjavaproject.ui.main

import android.os.Bundle
import android.util.Log
import com.example.mvvmrxjavaproject.R
import com.example.mvvmrxjavaproject.base.activity.BaseActivity
import com.example.mvvmrxjavaproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
    }

    private fun observeData() {
        viewModel.products.observe(this) {
            Log.e("TAG", "observeData: ${it.size}")
        }
    }
}