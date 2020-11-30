package com.example.kotlinstarter

import android.app.Application
import com.example.kotlinstarter.di.networkModule
import com.example.kotlinstarter.di.remoteDataSourceModule
import com.example.kotlinstarter.di.useCaseModule
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArticlesApp:Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)

        startKoin {
            androidContext(this@ArticlesApp)
            modules(
                networkModule,
             //   viewModelModule,
                // localDataSourceModule,
                remoteDataSourceModule,
                useCaseModule
            )
        }
    }
}