package com.example.apifacts.ui.home

import com.example.apifacts.model.Response
import com.example.apifacts.network.APIService
import retrofit2.Call
import retrofit2.Callback

class HomePresenter(

    private val apiService: APIService,
    private val view: HomeContract.View
)   : HomeContract.Presenter
{
    override fun getFacts(
        _id: String,
        _v: String,
        text: String,
        updatedAt: String,
        deleted: String,
        source: String,
        used: String
    ) {
        apiService.getFacts("cat", 11).enqueue(object : Callback<List<Response>> {
            override fun onFailure(call: Call<List<Response>>, t: Throwable) {
                view.showError("Please try again")
            }

            override fun onResponse(call: Call<List<Response>>, response: retrofit2.Response<List<Response>>) {
                if (response.isSuccessful) {
                    view.showResults(response.body()?: emptyList())
                } else {
                    view.showError("An unknown error occurred")
                }
            }
        })
    }
}
