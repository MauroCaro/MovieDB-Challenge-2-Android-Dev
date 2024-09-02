package com.app.data.movies.di

import com.app.data.movies.MovieRepositoryImpl
import com.app.data.movies.local.MovieDao
import com.app.data.movies.local.MovieLocalSource
import com.app.data.movies.local.MovieLocalSourceImpl
import com.app.data.movies.mapper.MovieDataMapper
import com.app.data.movies.mapper.MovieDomainMapper
import com.app.data.movies.remote.MovieAPI
import com.app.data.movies.remote.MovieRemoteSource
import com.app.domain.movies.MovieRepository
import com.app.domain.movies.model.Movie
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    fun provideMovieRepository(
        localSource: MovieLocalSource,
        domainMapper: MovieDomainMapper,
        dataMapper: MovieDataMapper,
        remoteSource: MovieRemoteSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            localSource, domainMapper, dataMapper, remoteSource
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
object MovieDataModule {

    @Provides
    @Singleton
    fun provideMovieLocalSource(
        dao: MovieDao
    ): MovieLocalSource {
        return MovieLocalSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideMovieApi(
        retrofit: Retrofit
    ): MovieAPI {
        return retrofit.create(MovieAPI::class.java)
    }

}