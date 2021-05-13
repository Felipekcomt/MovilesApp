package com.example.xtrememovieapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.xtrememovieapp.data.entities.Movie
@Dao
interface MovieDao {
    @Query("select * from movie")
    fun getAll(): MutableList<Movie>

    @Insert
    fun insert(vararg movie:Movie)
}