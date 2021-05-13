package com.example.xtrememovieapp.iu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.data.remote.ApiClient

class MainActivity : AppCompatActivity() {
    private lateinit var gotoFavorito: Button
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var moviesIntent = Intent(this,FavoritoActivity::class.java)
        initViews()
        initListeners(moviesIntent)
    }
    private fun initListeners(moviesIntent: Intent){
        gotoFavorito.setOnClickListener{
            Log.d("Marcio","F")
            startActivity(moviesIntent)
        }
    }
    private fun initViews() {
        gotoFavorito = findViewById(R.id.gotoFavorito)
        imageView = findViewById(R.id.imageView)
        Glide.with(this).load( "https://i.imgur.com/Zdwa0ND.jpg").into(imageView)
    }
}