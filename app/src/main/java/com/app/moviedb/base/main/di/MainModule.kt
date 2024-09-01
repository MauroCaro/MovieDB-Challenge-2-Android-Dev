package com.app.moviedb.base.main.di

import com.app.moviedb.base.main.resource.ResourceManager
import com.app.moviedb.base.navigation.Navigator
import com.app.moviedb.base.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MainModule {

    @Singleton
    @Binds
    fun bindAppNavigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    @Singleton
    fun bindResourceManager(resourceManagerImpl: ResourceManagerImpl): ResourceManager
}