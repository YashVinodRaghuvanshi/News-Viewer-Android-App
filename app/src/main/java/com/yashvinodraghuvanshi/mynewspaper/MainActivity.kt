package com.yashvinodraghuvanshi.mynewspaper

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.yashvinodraghuvanshi.mynewspaper.databinding.ActivityMainBinding


private lateinit var binding : ActivityMainBinding
lateinit var mAdapter : NewsAdaptor
class MainActivity : AppCompatActivity(), NewsAdaptor.NewsItemClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        loadItems()
        mAdapter = NewsAdaptor(this)
        binding.recyclerView.adapter = mAdapter
    }

    private fun loadItems()
    {
        val url = "https://newsapi.org/v2/top-headlines?country=us&apiKey=06dcab140fdc46178eb5f3cf7c82bfaf"
        val jsonObjectRequest = object : JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                val newsArrayObject = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()
                for(i in 0 until newsArrayObject.length())
                {
                    val newsJsonObject = newsArrayObject.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }


                mAdapter.updateNews(newsArray)

            },
            Response.ErrorListener {

            }
        )


// Add the request to the RequestQueue.


        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"]="Mozilla/5.0"
                return headers
            }
        }

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)


    }

    override fun onItemClicked(item: News) {
        Toast.makeText(this, "You clicked $item", Toast.LENGTH_LONG).show()
    }





}

