package com.vivek.movietrend.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.vivek.movietrend.network.ApiResult
import com.vivek.movietrend.presentation.components.ErrorScreen
import com.vivek.movietrend.presentation.viewmodel.MovieViewModel

@Composable
fun MovieDetailScreen(viewModel: MovieViewModel = hiltViewModel()) {
    val moviesDetailState by viewModel.movieDetails.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchMovieDetails("533535")
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                AsyncImage(
                    model = "https://image.tmdb.org/t/p/w500${result.data?.posterPath}",
                    contentDescription = result.data?.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = result.data?.title ?: "",
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = result.data?.overview ?: "",
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }

        is ApiResult.Error -> {
            ErrorScreen(result.exception.message)
        }
    }
}