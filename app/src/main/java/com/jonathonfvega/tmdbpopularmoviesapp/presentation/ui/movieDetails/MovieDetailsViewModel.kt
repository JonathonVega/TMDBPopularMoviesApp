package com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.movieDetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.MovieCredits
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.MovieDetails
import com.jonathonfvega.tmdbpopularmoviesapp.repository.TMDBRepositoryImpl
import com.jonathonfvega.tmdbpopularmoviesapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject
constructor(
    private val repository: TMDBRepositoryImpl,
) : ViewModel() {

    val movieDetails: MutableState<MovieDetails> = mutableStateOf(MovieDetails())

    val movieCredits: MutableState<MovieCredits> = mutableStateOf(MovieCredits())

    val loadingDetails = mutableStateOf(false)
    val loadingCredits = mutableStateOf(false)

    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {

            loadingDetails.value = true

            delay(2000)

            val result = repository.getMovieDetails(Constants.API_KEY, movieId)
            println("result follows...")
            println(result)
            movieDetails.value = result
            loadingDetails.value = false
        }
    }

    fun getMovieCredits(movieId: Int) {
        viewModelScope.launch {

            loadingCredits.value = true

            delay(2000)

            val result = repository.getMovieCredits(Constants.API_KEY, movieId)
            println("result follows...")
            println(result)
            movieCredits.value = result

            loadingCredits.value = false
        }
    }



}