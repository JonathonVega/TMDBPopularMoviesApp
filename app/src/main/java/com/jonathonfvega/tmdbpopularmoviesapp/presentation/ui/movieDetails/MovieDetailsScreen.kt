package com.jonathonfvega.tmdbpopularmoviesapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.components.BackDropHeaderImageView
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.components.PosterImageView
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.movieDetails.MovieDetailsViewModel
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.theme.TMDBColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesDetailsScreen(
    onNavigation:(String) -> Unit,
    viewModel: MovieDetailsViewModel,
    movieId:Int
){
    viewModel.getMovieDetails(movieId)
    viewModel.getMovieCredits(movieId)
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row() {
            movieHeaderCard(viewModel)
        }
        Row(modifier = Modifier.padding(top = 25.dp, start = 15.dp, end = 15.dp)) {
            movieOverviewCard(viewModel = viewModel)
        }
        Row(modifier = Modifier.padding(top = 25.dp)) {
            movieCastCard(viewModel)
        }
        Row(modifier = Modifier.padding(top = 25.dp)) {
            movieCrewCard(viewModel)
        }
    }
}

@Composable
fun movieHeaderCard(
    viewModel: MovieDetailsViewModel
){
    Card() {
        Column(modifier = Modifier.background(TMDBColor)) {
            Row() {
                Box() {
                    BackDropHeaderImageView(imageUrl = "https://image.tmdb.org/t/p/w500/${viewModel.movieDetails.value.backdropPath}")
                    Text(text = viewModel.movieDetails.value.originalTitle.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Row(modifier = Modifier.padding(start = 5.dp, top = 15.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                PosterImageView(imageUrl = "https://image.tmdb.org/t/p/w500/${viewModel.movieDetails.value.posterPath}")
                Column(modifier = Modifier.padding(start = 5.dp, end = 10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Release Date", color = Color.White, fontWeight = FontWeight.Bold)
                    Text(text = viewModel.movieDetails.value.releaseDate.toString(), color = Color.White)

                    Text(text = "Revenue", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                    Text(text = "$${viewModel.movieDetails.value.revenue.toString()}", color = Color.White)

                    Text(text = "Directed By:", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                    for(crew in viewModel.movieCredits.value.crew!!){
                        if(crew.job == "Director"){
                            Text(text = crew.name.toString(), color = Color.White)
                        }
                    }
                }
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = "Budget", color = Color.White, fontWeight = FontWeight.Bold)
                    Text(text = "$${viewModel.movieDetails.value.budget.toString()}", color = Color.White)

                    Text(text = "Budget", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                    Text(text = "${viewModel.movieDetails.value.status.toString()}", color = Color.White)

                    Text(text = "Genre:", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontWeight = FontWeight.Bold)
                    for(genre in viewModel.movieDetails.value.genres!!){
                        Text(text = genre.name.toString(), color = Color.White, modifier = Modifier.padding(top = 10.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun movieOverviewCard(
    viewModel: MovieDetailsViewModel
) {
    Card(shape = RoundedCornerShape(20.dp) ) {
        Column(modifier = Modifier
            .background(Color.DarkGray)
            .padding(horizontal = 15.dp, vertical = 10.dp)) {
            Text(text = "Overview", color = Color.White, fontSize = 20.sp)
            Text(text = viewModel.movieDetails.value.overview.toString(), color = Color.White, fontSize = 15.sp)
        }
    }
}

@Composable
fun movieCastCard(
    viewModel: MovieDetailsViewModel
) {
    Card() {
        Column(modifier = Modifier
            .background(TMDBColor)) {
            Row() {
                Text(text = "Cast", color = Color.White, fontSize = 20.sp)
            }
            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .background(TMDBColor)) {
                for (cast in viewModel.movieCredits.value.cast!!){
                    Column(modifier = Modifier
                        .padding(horizontal = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        PosterImageView(imageUrl = "https://image.tmdb.org/t/p/w500/${cast.profilePath}")
                        Text(text = cast.originalName.toString(),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,)
                        Text(text = cast.character.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(100.dp),
                            color = Color.White,)
                    }
                }
            }
        }
    }
}

@Composable
fun movieCrewCard(
    viewModel: MovieDetailsViewModel
){
    Card() {
        Column(modifier = Modifier
            .background(TMDBColor)) {
            Row() {
                Text(text = "Cast", color = Color.White, fontSize = 20.sp)
            }
            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .background(TMDBColor)) {
                for (crew in viewModel.movieCredits.value.crew!!){
                    Column(modifier = Modifier
                        .padding(horizontal = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        PosterImageView(imageUrl = "https://image.tmdb.org/t/p/w500/${crew.profilePath}")
                        Text(text = crew.originalName.toString(),
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,)
                        Text(text = crew.job.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(100.dp),
                            color = Color.White,)
                    }
                }
            }
        }

    }
}