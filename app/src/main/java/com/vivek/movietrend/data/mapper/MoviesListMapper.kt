package com.vivek.movietrend.data.mapper

import com.vivek.movietrend.data.model.MovieDto
import com.vivek.movietrend.domain.MovieDomain

fun MovieDto.toDomain() = MovieDomain(
    id = this.id,
    title = this.title,
    posterPath = this.poster_path
)


