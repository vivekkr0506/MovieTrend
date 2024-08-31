package com.vivek.movietrend.data.remote

import com.vivek.movietrend.data.mapper.toDomain
import com.vivek.movietrend.domain.MovieDetail
import com.vivek.movietrend.domain.MovieDomain
import com.vivek.movietrend.network.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(
    private val apiService: MoviesService,
) : MoviesRemoteDataSource {

    override fun getTrendingMovies(): Flow<ApiResult<List<MovieDomain>?>> = flow {
        try {
            val response = apiService.getTrendingMovies()
            emit(ApiResult.Success(response.results.map { it.toDomain() }))
        } catch (e: Exception) {
            emit(ApiResult.Error(e))
        }
    }

    override fun getMovieDetails(id: String): Flow<ApiResult<MovieDetail?>> = flow {
        try {
            val response = apiService.getMovieDetails(id = id)
            emit(ApiResult.Success(response.toDomain()))
        } catch (e: Exception) {
            emit(ApiResult.Error(e))
        }
    }
}


