package com.example.seekoassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SeekoApplication : Application() {

    companion object{
        @JvmStatic
        var instance :SeekoApplication?= null
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }

}