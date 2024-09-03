package com.app.moviedb.base.main.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.app.moviedb.base.navigation.NavigationEffects
import com.app.ui_common.components.theme.AppTheme
import com.app.moviedb.base.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = mainViewModel.navigationChannel,
        navHostController = navController
    )
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainNavigation(navController)
        }
    }
}
