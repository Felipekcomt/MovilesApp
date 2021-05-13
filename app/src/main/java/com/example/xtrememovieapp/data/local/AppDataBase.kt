package com.example.xtrememovieapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xtrememovieapp.data.entities.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getDao(): MovieDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase{
            if (INSTANCE == null){
                Room.databaseBuilder(context,AppDataBase::class.java, "movie.db").build()
            }
            return INSTANCE as AppDataBase
        }
    }

}