package com.example.mvvmrxjavaproject.di.component

import android.app.Application
import com.example.mvvmrxjavaproject.base.application.App
import com.example.mvvmrxjavaproject.di.module.ActivityBuilderModule
import com.example.mvvmrxjavaproject.di.module.AppModule
import com.example.mvvmrxjavaproject.di.module.FragmentBuilderModule
import com.example.mvvmrxjavaproject.di.module.NetworkModule
import com.example.mvvmrxjavaproject.di.module.RepositoryModule
import com.example.mvvmrxjavaproject.di.module.SharedPreferenceModule
import com.example.mvvmrxjavaproject.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        NetworkModule::class,
        SharedPreferenceModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}