package com.example.xtrememovieapp.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.data.entities.Movie
import com.example.xtrememovieapp.data.remote.ApiClient
import com.example.xtrememovieapp.data.remote.ApiResponse
import com.example.xtrememovieapp.iu.adapters.FavoritoAdapter
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritoActivity : AppCompatActivity() {
    private lateinit var favoritoAdapter: FavoritoAdapter
    private lateinit var  rv_movies: RecyclerView
    private var movies: MutableList<Movie> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorito)
        initViews()
    }

    private fun initViews() {
        rv_movies = findViewById(R.id.rv_movies)
        favoritoAdapter = FavoritoAdapter(this,movies)
        rv_movies.adapter = favoritoAdapter
        rv_movies.layoutManager = LinearLayoutManager(this)
        searchMovie()
    }

    private fun searchMovie() {
        val apiKey = "3cae426b920b29ed2fb1c0749f258325"
        val movieInterface = ApiClient.build()
        val searchMovie = movieInterface?.getAllMovie(apiKey)
        searchMovie?.enqueue(object: Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful){
                    movies = response.body()!!.results
                    favoritoAdapter.setItems(movies)
                    Log.d("MarcioCPP", Gson().toJson(response.body()))
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t?.printStackTrace()
            }

        })
    }
}