package com.vivek.movietrend.data.repository

import com.vivek.movietrend.domain.MovieDetail
import com.vivek.movietrend.domain.MovieDomain
import com.vivek.movietrend.network.ApiResult
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getTrendingMovies(): Flow<ApiResult<List<MovieDomain>?>>
    fun getMovieDetail(id: String): Flow<ApiResult<MovieDetail?>>
}