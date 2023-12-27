package com.example.mvvmrxjavaproject.di.module

import com.example.mvvmrxjavaproject.data.session.AppPreference
import com.example.mvvmrxjavaproject.data.session.Session
import dagger.Binds
import dagger.Module

@Module
abstract class SessionModule {

    @Binds
    abstract fun bindSession(preference: AppPreference): Session
}