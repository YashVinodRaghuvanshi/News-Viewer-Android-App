package com.yashvinodraghuvanshi.mynewspaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdaptor(val items : ArrayList<String>) : RecyclerView.Adapter<NewsAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv.text = items[position]


    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val tv : TextView = itemView.findViewById(R.id.textViewList)

    }
}