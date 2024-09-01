package com.vivek.movietrend.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vivek.movietrend.presentation.screen.MovieDetailScreen
import com.vivek.movietrend.presentation.screen.MovieListScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "movieList") {
        composable("movieList") {
            MovieListScreen(navController = navController)
        }
        composable("movieDetail/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            MovieDetailScreen(movieId = movieId ?: "", navController = navController)
        }
    }
}