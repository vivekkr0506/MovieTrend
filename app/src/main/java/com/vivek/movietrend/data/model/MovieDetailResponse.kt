package com.vivek.movietrend.data.model

data class MovieDetailResponse(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String
)