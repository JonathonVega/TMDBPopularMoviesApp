package com.jonathonfvega.tmdbpopularmoviesapp.repository

import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie

interface TMDBRepository {
    suspend fun getPopularMovies(key: String, page: Int):List<Movie>
//    suspend fun getMovieDetails(key: String, id: Int)
//    suspend fun getMovieImages(key: String, id: Int)


}