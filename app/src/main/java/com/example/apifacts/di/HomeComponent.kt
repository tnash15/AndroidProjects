package com.example.apifacts.di

import com.example.apifacts.ui.home.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent{
    fun inject (mainActivity: MainActivity)
}