package com.example.xtrememovieapp.iu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xtrememovieapp.R
import com.example.xtrememovieapp.data.entities.Movie
import com.example.xtrememovieapp.data.remote.ApiClient

class FavoritoAdapter (private val context: Context, private var movies: MutableList<Movie>): RecyclerView.Adapter<FavoritoAdapter.FavoritoItem>(){
    inner class FavoritoItem(view: View): RecyclerView.ViewHolder(view)
    {
        private lateinit var listtitle: TextView
        private lateinit var listoverview: TextView
        private lateinit var listpopularity: TextView
        private lateinit var  imagen: ImageView
        private lateinit var btn_favorite: ImageButton

        fun bindto(movie: Movie){
            listtitle = itemView.findViewById(R.id.tvlist_names_movies)
            listtitle.text = movie.title
            listoverview = itemView.findViewById(R.id.tvlist_overview_movies)
            listoverview.text = movie.overview
            listpopularity = itemView.findViewById(R.id.tvlist_popularity_movies)
            listpopularity.text = movie.popularity
            imagen = itemView.findViewById(R.id.imglist_movies)
            Glide.with(context).load(ApiClient.IMAGE_BASE_URL + movie.poster_path).into(imagen)
        }
    }
    fun setItems(movies: MutableList<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritoAdapter.FavoritoItem{
        val view = LayoutInflater.from(context).inflate(R.layout.items_movies,parent, false)
        return FavoritoItem(view)
    }

    override fun onBindViewHolder(holder: FavoritoAdapter.FavoritoItem, position: Int) {
        holder.bindto(movies[position])
    }
    override fun getItemCount(): Int{
        return movies.size
    }
}
