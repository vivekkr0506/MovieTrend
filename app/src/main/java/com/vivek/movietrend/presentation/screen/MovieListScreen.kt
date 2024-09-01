package com.vivek.movietrend.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vivek.movietrend.network.ApiResult
import com.vivek.movietrend.presentation.components.ErrorScreen
import com.vivek.movietrend.presentation.components.MovieList
import com.vivek.movietrend.presentation.viewmodel.MovieViewModel

@Composable
fun MovieListScreen(viewModel: MovieViewModel = hiltViewModel()) {
    val moviesState by viewModel.trendingMovies.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchTrendingMovies()
    }

    when (val result = moviesState) {
        is ApiResult.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiResult.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(result.data ?: emptyList()) { movie ->
                    MovieList(movie) {}
                }
            }
        }

        is ApiResult.Error -> {
            ErrorScreen(result.exception.message)
        }
    }
}


