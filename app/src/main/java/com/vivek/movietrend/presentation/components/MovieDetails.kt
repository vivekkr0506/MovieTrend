package com.vivek.movietrend.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MovieDetails(title: String?, posterPath: String?, overview: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${posterPath}",
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = title ?: "",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = overview ?: "",
            style = MaterialTheme.typography.titleSmall,
        )
    }
}