package com.example.xtrememovieapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class Movie (
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val overview: String,
    @ColumnInfo
    val popularity: String,
    @ColumnInfo
    val poster_path: String,
    @ColumnInfo
    val isFavorite: Int
    )
