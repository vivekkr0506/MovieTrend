package com.vivek.movietrend.data.remote

import com.vivek.movietrend.domain.MovieDetail
import com.vivek.movietrend.domain.MovieDomain
import com.vivek.movietrend.network.ApiResult
import kotlinx.coroutines.flow.Flow

interface MoviesRemoteDataSource {
    fun getTrendingMovies(): Flow<ApiResult<List<MovieDomain>?>>
    fun getMovieDetails(id: String): Flow<ApiResult<MovieDetail?>>
}