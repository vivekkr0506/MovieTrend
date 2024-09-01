package com.vivek.movietrend.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.vivek.movietrend.domain.MovieDomain

@Composable
fun MovieList(movies: MovieDomain, onMovieClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp).clickable { onMovieClick(movies.id) },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movies.posterPath}",
            contentDescription = movies.title,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            maxLines = 2,
            text = movies.title,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}