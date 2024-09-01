package com.vivek.movietrend.data.remote

import com.vivek.movietrend.BuildConfig
import com.vivek.movietrend.data.model.MovieDetailResponse
import com.vivek.movietrend.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MoviesService {
    @GET("movie/popular")
    suspend fun getTrendingMovies(
        @Header("Authorization") token : String = "Bearer "+BuildConfig.TOKEN
    ): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int,
        @Header("Authorization") token : String = "Bearer "+BuildConfig.TOKEN
    ): MovieDetailResponse
}
