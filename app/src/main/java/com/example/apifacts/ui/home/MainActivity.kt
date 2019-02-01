package com.example.apifacts.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.apifacts.App
import com.example.apifacts.R
import com.example.apifacts.di.DaggerHomeComponent
import com.example.apifacts.di.HomeModule
import com.example.apifacts.model.Response
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val APIAdapter = APIAdapter()

    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = APIAdapter

        btnRandomFacts.setOnClickListener {
            homePresenter.getFacts(_id = String(), _v = String(), text = String(),
                updatedAt = String(), deleted = String(),
                source = String(), used = String())
        }
    }

override fun showResults(results: List<Response>) {
    APIAdapter.setFacts(results)
}

override fun showError(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
