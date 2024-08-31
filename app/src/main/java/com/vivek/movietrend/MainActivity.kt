package com.vivek.movietrend

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vivek.movietrend.network.ApiResult
import com.vivek.movietrend.presentation.MovieViewModel
import com.vivek.movietrend.ui.theme.MovieTrendTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieTrendTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val  viewModel: MovieViewModel = hiltViewModel()
    val moviesState by viewModel.trendingMovies.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchTrendingMovies()
    }

    when (val result = moviesState) {
        is ApiResult.Loading -> {
            CircularProgressIndicator()
        }
        is ApiResult.Success -> {
            Log.e("Vivek",result.data.toString())
        }
        is ApiResult.Error -> {
            Text(text = "Error: ${result.exception.message}")
        }
    }
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieTrendTheme {
        Greeting("Android")
    }
}