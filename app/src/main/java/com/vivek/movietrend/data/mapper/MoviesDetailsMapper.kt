package com.vivek.movietrend.data.mapper

import com.vivek.movietrend.data.model.MovieDetailResponse
import com.vivek.movietrend.domain.MovieDetail

fun MovieDetailResponse.toDomain() = MovieDetail(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterPath = this.poster_path
)