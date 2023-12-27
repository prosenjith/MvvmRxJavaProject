package com.example.mvvmrxjavaproject.di.module

import android.app.Application
import android.content.Context
import com.example.mvvmrxjavaproject.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun bindApplicationContext(application: Application): Context
}