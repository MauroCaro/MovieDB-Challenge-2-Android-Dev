package com.app.moviedb.base.main.di

import android.content.Context
import androidx.annotation.StringRes
import com.app.moviedb.base.main.resource.ResourceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ResourceManager {

    override fun getString(@StringRes resId: Int): String = context.getString(resId)
}