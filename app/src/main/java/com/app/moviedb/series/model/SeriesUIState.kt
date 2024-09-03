package com.app.moviedb.series.model

import kotlinx.collections.immutable.ImmutableList

sealed class SeriesUIState {

    data object Loading : SeriesUIState()
    data class Show(val series: ImmutableList<SeriesUI>) : SeriesUIState()
    data object Empty : SeriesUIState()
}