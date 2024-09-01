package com.app.moviedb.base.main.resource

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resId: Int): String
}