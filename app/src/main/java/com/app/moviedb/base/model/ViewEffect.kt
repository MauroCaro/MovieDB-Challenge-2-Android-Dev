package com.app.moviedb.base.model

import com.app.login.base.bottom_sheet.BottomSheetBuilder

interface ViewEffect

data class ShowDialog(
    val builder: BottomSheetBuilder,
) : ViewEffect

