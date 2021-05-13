package com.example.xtrememovieapp.data.remote

import com.example.xtrememovieapp.data.entities.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//BASE_URL: "https://api.themoviedb.org/3/movie/
interface MovieInterface {
    @GET("movie/popular")
    fun getAllMovie(@Query("api_key") apiKey: String): Call<ApiResponse>

}