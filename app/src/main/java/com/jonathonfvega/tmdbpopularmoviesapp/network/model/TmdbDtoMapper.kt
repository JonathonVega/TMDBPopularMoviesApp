package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.Movie

class TmdbDtoMapper {

    fun mapToDomainModel(model: MovieDto): Movie {
        return Movie(
            posterPath = model.posterPath,
            adult = model.adult,
            overview = model.overview,
            releaseDate = model.releaseDate,
            genreIds = model.genreIds,
            id = model.movieId,
            originalTitle = model.originalTitle,
            originalLanguage = model.originalLanguage,
            title = model.title
        )
    }

    fun toDomainList(initial: List<MovieDto>): List<Movie>{
        return initial.map { mapToDomainModel(it) }
    }

}