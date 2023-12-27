package com.example.mvvmrxjavaproject.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.mvvmrxjavaproject.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferenceModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            "${context.packageName}_preference",
            Context.MODE_PRIVATE
        )
    }
}