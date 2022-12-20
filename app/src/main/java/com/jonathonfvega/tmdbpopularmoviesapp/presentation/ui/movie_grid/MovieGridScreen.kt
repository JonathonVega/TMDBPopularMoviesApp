package com.jonathonfvega.tmdbpopularmoviesapp

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.components.MovieCard
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.movie_grid.PAGE_SIZE
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.movie_grid.PopularMoviesViewModel
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.theme.TMDBColor

@Composable
fun MovieGridScreen(
    onNavigation:(String) -> Unit,

){
    val viewModel = hiltViewModel<PopularMoviesViewModel>()
    val moviesList = viewModel.movies.value
    val loading = viewModel.loading.value
    val page = viewModel.page.value

    val state = rememberLazyListState(
        initialFirstVisibleItemIndex = 99
    )

    LazyVerticalGrid(columns = GridCells.Fixed(2), Modifier.background(TMDBColor), content = {
        itemsIndexed(items = moviesList) {index, movie ->
            println(movie)
            viewModel.onChangeMovieScrollPosition(index)
            if((index + 1) >= (page * PAGE_SIZE) && !loading){
                viewModel.nextPage()
            }
            MovieCard(movie = movie,onNavigation=onNavigation) {

            }
        }
    })
}