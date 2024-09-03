package com.app.data.series.di

import com.app.data.series.SeriesRepositoryImpl
import com.app.data.series.local.SeriesDao
import com.app.data.series.local.SeriesLocalSource
import com.app.data.series.local.SeriesLocalSourceImpl
import com.app.data.series.mapper.SeriesDataMapper
import com.app.data.series.mapper.SeriesDomainMapper
import com.app.data.series.remote.SeriesAPI
import com.app.data.series.remote.SeriesRemoteSource
import com.app.domain.series.SeriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SeriesModule {

    @Provides
    fun provideSeriesRepository(
        localSource: SeriesLocalSource,
        domainMapper: SeriesDomainMapper,
        dataMapper: SeriesDataMapper,
        remoteSource: SeriesRemoteSource
    ): SeriesRepository {
        return SeriesRepositoryImpl(
            localSource, domainMapper, dataMapper, remoteSource
        )
    }
}

@Module
@InstallIn(SingletonComponent::class)
object SeriesDataModule {

    @Provides
    @Singleton
    fun provideSeriesLocalSource(
        dao: SeriesDao
    ): SeriesLocalSource {
        return SeriesLocalSourceImpl(dao)
    }

    @Provides
    @Singleton
    fun provideSeriesApi(
        retrofit: Retrofit
    ): SeriesAPI {
        return retrofit.create(SeriesAPI::class.java)
    }

}