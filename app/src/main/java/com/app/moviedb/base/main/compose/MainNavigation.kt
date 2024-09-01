package com.app.moviedb.base.main.compose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.moviedb.base.navigation.Destination
import com.app.moviedb.base.navigation.NavHost
import androidx.navigation.*
import com.app.moviedb.base.navigation.composable

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen
    ) {
        composable(destination = Destination.HomeScreen) {
            // HomeScreen()
            //val loginViewModelL: LoginViewModel = hiltViewModel()
           // ViewEventHost(loginViewModelL)
        }
        composable(destination = Destination.DetailScreen) {
        }
    }
}