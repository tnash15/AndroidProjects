package com.example.apifacts.di

import com.example.apifacts.network.APIService
import com.example.apifacts.ui.home.HomeContract
import com.example.apifacts.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View){

    @HomeScope
    @Provides
    fun provideHomePresenter(apiService: APIService): HomeContract.Presenter{
        return HomePresenter(apiService, view)
    }
}
