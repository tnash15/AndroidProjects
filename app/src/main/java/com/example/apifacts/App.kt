package com.example.apifacts

import android.app.Application
import com.example.apifacts.di.AppComponent
import com.example.apifacts.di.DaggerAppComponent

class App : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    fun getComponent() = appComponent
}