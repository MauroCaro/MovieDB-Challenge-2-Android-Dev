package com.app.moviedb.base.model

import com.app.moviedb.base.ui.bottom_sheet.BottomSheetBuilder

interface ViewEffect

data class ShowDialog(
    val builder: BottomSheetBuilder,
) : ViewEffect

