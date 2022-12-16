package com.jonathonfvega.tmdbpopularmoviesapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit,
){
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .height(360.dp)
            .padding(
                bottom = 6.dp,
                top = 6.dp,
                start = 2.dp,
                end = 2.dp,

                )
            .fillMaxWidth()
            .clickable(onClick = {

            }),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ImageView(imageUrl = "https://image.tmdb.org/t/p/w500/${movie.posterPath}")
            Row(modifier = Modifier.height(50.dp)) {
                Text(
                    text = movie.title.toString(),
                    textAlign = TextAlign.Center
                )
            }
        }


    }
}