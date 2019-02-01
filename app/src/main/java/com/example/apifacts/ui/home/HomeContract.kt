package com.example.apifacts.ui.home

import com.example.apifacts.model.Response

class HomeContract {

    interface View{
        fun showResults(results: List<Response>)
        fun showError(message: String)
    }

    interface Presenter{
        fun getFacts (_id: String, _v: String, text: String, updatedAt: String, deleted: String, source: String, used: String)
    }
}