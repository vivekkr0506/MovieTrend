package com.vivek.movietrend.data.remote

import com.vivek.movietrend.BuildConfig
import com.vivek.movietrend.data.model.MovieDetailResponse
import com.vivek.movietrend.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("language") language: String = "en-US",
        @Query("api_key") api_key: String = BuildConfig.API_KEY,
        @Query("page") page : Int = 1
    ): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int,
        @Query("api_key") api_key: String = BuildConfig.API_KEY,
    ): MovieDetailResponse
}