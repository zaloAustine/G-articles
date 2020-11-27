package com.example.kotlinstarter.ui

import android.app.Application
import com.example.kotlinstarter.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by FBada on 18/09/2020.
 */
@HiltAndroidApp
class FoodApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
