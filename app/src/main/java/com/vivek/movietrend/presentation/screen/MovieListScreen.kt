package com.vivek.movietrend.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vivek.movietrend.domain.MovieDomain
import com.vivek.movietrend.network.ApiResult
import com.vivek.movietrend.presentation.components.ErrorScreen
import com.vivek.movietrend.presentation.components.MovieList
import com.vivek.movietrend.presentation.viewmodel.MovieViewModel

@Composable
fun MovieListScreen(navController: NavController, viewModel: MovieViewModel = hiltViewModel()) {

    val moviesState by viewModel.trendingMovies.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var filteredMovies by remember { mutableStateOf<List<MovieDomain>>(emptyList()) }

    LaunchedEffect(Unit) {
        viewModel.fetchTrendingMovies()
    }

    LaunchedEffect(moviesState, searchQuery) {
        filteredMovies = when (val result = moviesState) {
            is ApiResult.Success -> {
                result.data?.filter { movie ->
                    movie.title.contains(searchQuery, ignoreCase = true)
                } ?: emptyList()
            }

            else -> emptyList()
        }
    }
    Column(Modifier.padding(top = 30.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query -> searchQuery = query },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        when (val result = moviesState) {
            is ApiResult.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is ApiResult.Success -> {

                if (filteredMovies.isEmpty()) {
                    ErrorScreen(errorMsg = "No Result Found")
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(filteredMovies) { movie ->
                            MovieList(movie) { navController.navigate("movieDetail/${movie.id}") }
                        }
                    }
                }

            }

            is ApiResult.Error -> {
                ErrorScreen(result.exception.message)
            }
        }
    }
}


