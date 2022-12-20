package com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui

sealed class Screen(
    val route:String,
){
    object MoviesGrid: Screen("moviesGrid")
    object MoviesDetails: Screen("moviesDetails")
}
