package com.example.mvvmrxjavaproject.di.module

import com.example.mvvmrxjavaproject.data.repository.FakeStoreRepository
import com.example.mvvmrxjavaproject.data.repository.FakeStoreRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindFakeRepository(repository: FakeStoreRepositoryImpl): FakeStoreRepository
}