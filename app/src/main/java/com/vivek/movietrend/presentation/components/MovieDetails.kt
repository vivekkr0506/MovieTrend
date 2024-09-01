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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MovieDetails(
    title: String?,
    posterPath: String?,
    overview: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${posterPath}",
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 40.dp, bottom = 20.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = title ?: "",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 26.sp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = overview ?: "",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}