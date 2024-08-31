package com.vivek.movietrend.data.remote

import com.vivek.movietrend.data.model.MovieDetailResponse
import com.vivek.movietrend.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/popular")
    suspend fun getTrendingMovies(): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: String
    ): MovieDetailResponse
}
