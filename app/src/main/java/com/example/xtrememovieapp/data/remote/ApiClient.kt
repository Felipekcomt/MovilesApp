package com.example.xtrememovieapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    private const val API_BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_URL= "https://image.tmdb.org/t/p/w500"
    private var movieInterface: MovieInterface? = null
    fun build(): MovieInterface?{
        val builder = Retrofit.Builder().baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder.build()

        movieInterface = retrofit.create(MovieInterface::class.java)

        return movieInterface as MovieInterface
    }
}