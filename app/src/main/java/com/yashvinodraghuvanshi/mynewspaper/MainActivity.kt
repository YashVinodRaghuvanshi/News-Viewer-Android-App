package com.yashvinodraghuvanshi.mynewspaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yashvinodraghuvanshi.mynewspaper.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity(), NewsAdaptor.NewsItemClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var items = loadItems()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter : NewsAdaptor = NewsAdaptor(items ,this)
        binding.recyclerView.adapter = adapter
    }

    private fun loadItems() : ArrayList<String>
    {
        val list = ArrayList<String>()
        for(x in 0 until 100){
            list.add("list number $x")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "You clicked $item", Toast.LENGTH_LONG).show()
    }
}