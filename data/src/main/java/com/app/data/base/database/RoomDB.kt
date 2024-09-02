package com.app.data.base.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.data.movies.local.MovieDao
import com.app.data.movies.model.MovieEntity

@Database(
    entities = [
        MovieEntity::class
    ], version = 1, exportSchema = false
)
abstract class RoomDao : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}