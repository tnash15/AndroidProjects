package com.example.apifacts.di

import com.example.apifacts.network.APIService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent{
    fun APIService(): APIService
}