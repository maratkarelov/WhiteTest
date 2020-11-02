package com.example.white

import android.annotation.SuppressLint
import android.app.Application
import com.example.white.di.apiModule
import com.example.white.di.netModule
import com.example.white.di.roomDataSourceModule
import com.example.white.di.viewModelModule
import io.reactivex.plugins.RxJavaPlugins
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {

    @SuppressLint("CheckResult")
    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { e: Throwable? ->
            e?.let {
            }
        }
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            koin.loadModules(
                mutableListOf(
                    viewModelModule,
                    netModule,
                    apiModule,
                    roomDataSourceModule
                )
            )
        }
    }
}