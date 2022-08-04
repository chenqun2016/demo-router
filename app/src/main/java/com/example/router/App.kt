package com.example.router

import androidx.multidex.MultiDexApplication
import com.example.router.runtime.Router

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        Router.init()
    }
}