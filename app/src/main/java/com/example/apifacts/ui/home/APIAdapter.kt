package com.example.apifacts.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.apifacts.R
import com.example.apifacts.model.Response

class APIAdapter : RecyclerView.Adapter<APIAdapter.APIViewHolder>(){

    private val facts = arrayListOf<Response>()

    fun setFacts(items: List<Response>){
        facts.clear()
        facts.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): APIViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent,false)
        return APIViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return facts.size
    }

    override fun onBindViewHolder(viewHolder: APIViewHolder, position: Int) {
        viewHolder.bind(facts[position])
    }

    class APIViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(facts: Response) {
            val tv_id = view.findViewById<TextView>(R.id.tv_id)
            tv_id.text = facts._id

            val tv_v = view.findViewById<TextView>(R.id.tv_v)
            tv_v.text = facts._v

            val tvtext = view.findViewById<TextView>(R.id.tvtext)
            tvtext.text = facts.text

            val tvupdatedAt = view.findViewById<TextView>(R.id.tvupdatedAt)
            tvupdatedAt.text = facts.updatedAt

            val tvdeleted = view.findViewById<TextView>(R.id.tvdeleted)
            tvdeleted.text = facts.deleted

            val tvsource = view.findViewById<TextView>(R.id.tvsource)
            tvsource.text = facts.source

            val tvused = view.findViewById<TextView>(R.id.tvused)
            tvused.text = facts.used
        }
    }
}