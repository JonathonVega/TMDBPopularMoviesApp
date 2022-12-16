package com.jonathonfvega.tmdbpopularmoviesapp.repository

import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie
import com.jonathonfvega.tmdbpopularmoviesapp.network.TMDBService
import com.jonathonfvega.tmdbpopularmoviesapp.network.model.TmdbDtoMapper
import javax.inject.Inject

class TMDBRepositoryImpl @Inject constructor(
    private val TMDBService: TMDBService,
    private val mapper: TmdbDtoMapper): TMDBRepository {

    override suspend fun getPopularMovies(key: String, page: Int): List<Movie> {
        return mapper.toDomainList((TMDBService.getPopularMovies(key, page)).results)
    }


}