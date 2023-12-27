package com.example.mvvmrxjavaproject.di.module

import com.example.mvvmrxjavaproject.ui.main.MainActivity
import com.example.mvvmrxjavaproject.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}