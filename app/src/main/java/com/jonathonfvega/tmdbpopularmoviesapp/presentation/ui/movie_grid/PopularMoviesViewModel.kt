package com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.movie_grid

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie
import com.jonathonfvega.tmdbpopularmoviesapp.repository.TMDBRepositoryImpl
import com.jonathonfvega.tmdbpopularmoviesapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

const val PAGE_SIZE = 20

@HiltViewModel
class PopularMoviesViewModel @Inject
constructor(
    private val repository: TMDBRepositoryImpl,
) : ViewModel() {

    val movies: MutableState<List<Movie>> = mutableStateOf(ArrayList())

    val loading = mutableStateOf(false)

    val page = mutableStateOf(1)

    var movieListScrollPosition = 0

    var selectedMovieId: Int? = null

    fun setMovieId(movieId: Int) {
        selectedMovieId = movieId
    }

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {

            loading.value = true

            resetSearchState()

            delay(2000)

            val result = repository.getPopularMovies(Constants.API_KEY, 1)
            movies.value = result

            loading.value = false
        }
    }

    fun nextPage(){
        viewModelScope.launch {
            println(movieListScrollPosition )
            println(page.value)
            println()
            if((movieListScrollPosition + 1) >= (page.value * PAGE_SIZE)){
                loading.value = true
                page.value += 1

                if(page.value > 1){
                    val result = repository.getPopularMovies(Constants.API_KEY, page.value)
                    val current = ArrayList(movies.value)
                    current.addAll(result)
                    movies.value = current
                }
                loading.value = false
            }
        }
    }

    private fun resetSearchState() {
        movies.value = listOf()
        page.value = 1
        onChangeMovieScrollPosition(0)
    }

    fun onChangeMovieScrollPosition(position: Int){
        movieListScrollPosition = position
    }

}