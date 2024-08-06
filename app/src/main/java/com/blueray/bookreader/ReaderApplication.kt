package com.blueray.bookreader

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltAndroidApp
class ReaderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}