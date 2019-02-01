package com.example.apifacts.network

import com.example.apifacts.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.temporal.TemporalAmount

interface APIService{

    @GET(END_POINT)
    fun getFacts(@Query("animal") animal: String,
                 @Query("amount") amount: Int): Call<List<Response>>
}