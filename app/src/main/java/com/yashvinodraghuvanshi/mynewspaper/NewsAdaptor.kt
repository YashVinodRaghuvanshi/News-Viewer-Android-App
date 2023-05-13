package com.yashvinodraghuvanshi.mynewspaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdaptor(private val listner : NewsItemClick) : RecyclerView.Adapter<NewsAdaptor.ViewHolder>() {

    val items : ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener{
            listner.onItemClicked(items[viewHolder.adapterPosition])

        }
        return viewHolder

    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv.text = items[position].title


    }

    fun updateNews(updatedNews : ArrayList<News>){

        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()

    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val tv : TextView = itemView.findViewById(R.id.textViewList)

    }

    interface NewsItemClick{
        fun onItemClicked(item : News)
    }
}