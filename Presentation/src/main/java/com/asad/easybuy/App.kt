package com.asad.easybuy

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    private var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}