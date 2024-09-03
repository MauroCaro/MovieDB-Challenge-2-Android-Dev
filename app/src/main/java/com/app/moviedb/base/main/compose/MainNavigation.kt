package com.app.moviedb.base.main.compose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.moviedb.base.navigation.Destination
import com.app.moviedb.base.navigation.NavHost
import androidx.navigation.*
import com.app.moviedb.base.navigation.composable
import com.app.moviedb.home.compose.HomeScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen
    ) {
        composable(destination = Destination.HomeScreen) {
            HomeScreen()
        }
        composable(destination = Destination.DetailScreen) {
        }
    }
}