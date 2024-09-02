package com.app.data.base.database

import android.app.Application
import androidx.room.Room
import com.app.data.movies.local.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): RoomDao {
        return Room.databaseBuilder(
            app,
            RoomDao::class.java,
            "RoomDB"
        ).fallbackToDestructiveMigration().build()
    }


    @Provides
    fun provideUserDao(database: RoomDao): MovieDao {
        return database.movieDao()
    }
}