package com.vivek.movietrend.data.repository

import com.vivek.movietrend.data.remote.MoviesRemoteDataSource
import com.vivek.movietrend.domain.MovieDetail
import com.vivek.movietrend.domain.MovieDomain
import com.vivek.movietrend.network.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {

    override fun getTrendingMovies(): Flow<ApiResult<List<MovieDomain>?>> {
        return moviesRemoteDataSource.getTrendingMovies()
    }

    override fun getMovieDetail(id: String): Flow<ApiResult<MovieDetail?>> {
        return moviesRemoteDataSource.getMovieDetails(id)
    }
}