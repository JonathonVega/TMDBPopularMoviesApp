package com.jonathonfvega.tmdbpopularmoviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jonathonfvega.tmdbpopularmoviesapp.components.MovieCard
import com.jonathonfvega.tmdbpopularmoviesapp.ui.theme.TMDBColor
import com.jonathonfvega.tmdbpopularmoviesapp.ui.theme.TMDBPopularMoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    lateinit var application: BaseApplication

//    private val viewModel: PopularMoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBPopularMoviesAppTheme {
                val viewModel = hiltViewModel<PopularMoviesViewModel>()
                val moviesList = viewModel.movies.value
                val loading = viewModel.loading.value
                val page = viewModel.page.value

                val state = rememberLazyListState(
                    initialFirstVisibleItemIndex = 99
                )

//                var moviesList = arrayListOf("hello", "yes")
                LazyVerticalGrid(columns = GridCells.Fixed(2), Modifier.background(TMDBColor), content = {
                    itemsIndexed(items = moviesList) {index, movie ->
                        println(movie)
                        viewModel.onChangeMovieScrollPosition(index)
                        if((index + 1) >= (page * PAGE_SIZE) && !loading){
                            viewModel.nextPage()
                        }
                        MovieCard(movie = movie) {

                        }
                    }
                })
            }
        }
    }
}