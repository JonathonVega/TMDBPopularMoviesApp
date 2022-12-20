package com.jonathonfvega.tmdbpopularmoviesapp.repository

import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.MovieCredits
import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.MovieDetails
import com.jonathonfvega.tmdbpopularmoviesapp.network.TMDBService
import com.jonathonfvega.tmdbpopularmoviesapp.network.model.TmdbDtoMapper
import javax.inject.Inject

class TMDBRepositoryImpl @Inject constructor(
    private val TMDBService: TMDBService,
    private val mapper: TmdbDtoMapper): TMDBRepository {

    override suspend fun getPopularMovies(key: String, page: Int): List<Movie> {
        return mapper.toDomainMovieList((TMDBService.getPopularMovies(key, page)).results)
    }

    override suspend fun getMovieDetails(key: String, movieId: Int): MovieDetails {
        return mapper.toDomainMovieDetails((TMDBService.getMovieDetails(movieId, key)))
    }

    override suspend fun getMovieCredits(key: String, movieId: Int): MovieCredits {
        return mapper.toDomainMovieCredits((TMDBService.getMovieCredits(movieId, key)))
    }


}