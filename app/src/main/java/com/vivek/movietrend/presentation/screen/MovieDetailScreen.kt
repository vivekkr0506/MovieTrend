package com.vivek.movietrend.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vivek.movietrend.network.ApiResult
import com.vivek.movietrend.presentation.components.ErrorScreen
import com.vivek.movietrend.presentation.components.MovieDetails
import com.vivek.movietrend.presentation.viewmodel.MovieViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    movieId: String,
    navController: NavController,
    viewModel: MovieViewModel = hiltViewModel(),
) {
    val moviesDetailState by viewModel.movieDetails.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchMovieDetails(movieId.toInt())
    }

    when (val result = moviesDetailState) {
        is ApiResult.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiResult.Success -> {
            Scaffold(topBar = {
                Surface() {
                    TopAppBar(
                        title = { Text(text = "") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigate("movieList") }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.Blue
                                )
                            }
                        },
                    )
                }
            }, content = { paddingValues ->
                MovieDetails(
                    title = result.data?.title,
                    posterPath = result.data?.posterPath,
                    overview = result.data?.overview
                )
            })
        }

        is ApiResult.Error -> {
            ErrorScreen(result.exception.message)
        }
    }
}