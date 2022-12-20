package com.jonathonfvega.tmdbpopularmoviesapp.repository

import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.MovieCredits
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.MovieDetails

interface TMDBRepository {
    suspend fun getPopularMovies(key: String, page: Int):List<Movie>
    suspend fun getMovieDetails(key: String, id: Int): MovieDetails
    suspend fun getMovieCredits(key: String, id: Int): MovieCredits
//    suspend fun getMovieImages(key: String, id: Int)


}