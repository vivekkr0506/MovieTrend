package com.vivek.movietrend.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.movietrend.data.repository.MoviesRepository
import com.vivek.movietrend.domain.MovieDetail
import com.vivek.movietrend.domain.MovieDomain

import com.vivek.movietrend.network.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository,
) : ViewModel() {

    private val _trendingMovies = MutableStateFlow<ApiResult<List<MovieDomain>?>>(ApiResult.Loading)
    val trendingMovies: StateFlow<ApiResult<List<MovieDomain>?>> = _trendingMovies.asStateFlow()

    private val _movieDetails = MutableStateFlow<ApiResult<MovieDetail?>>(ApiResult.Loading)
    val movieDetails: StateFlow<ApiResult<MovieDetail?>> = _movieDetails.asStateFlow()

    fun fetchTrendingMovies() {
        viewModelScope.launch {
            moviesRepository.getTrendingMovies().collect { result ->
                _trendingMovies.value = result
            }
        }
    }

    fun fetchMovieDetails(id: Int) {
        viewModelScope.launch {
            moviesRepository.getMovieDetail(id).collect { result ->
                _movieDetails.value = result
            }
        }
    }
}
