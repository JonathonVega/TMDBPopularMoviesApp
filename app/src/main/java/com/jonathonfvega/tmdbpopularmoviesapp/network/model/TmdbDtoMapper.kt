package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.jonathonfvega.tmdbpopularmoviesapp.domain.model.*

class TmdbDtoMapper {

    private fun mapToDomainModel(model: MovieDto): Movie {
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

    private fun mapToDomainModel(model: MovieDetailsDto): MovieDetails {
        return MovieDetails(
            adult = model.adult,
            backdropPath = model.backdropPath,
            budget = model.budget,
            genres = model.genres?.let{toDomainGenreList(it)},
            id = model.id,
            originalLanguage = model.originalLanguage,
            originalTitle = model.originalTitle,
            overview = model.overview,
            posterPath = model.posterPath,
            releaseDate = model.releaseDate,
            revenue = model.revenue,
            status = model.status,
            title = model.title
        )
    }

    private fun mapToDomainModel(model: MovieCreditsDto): MovieCredits {
        return MovieCredits(
            id = model.id,
            cast = model.cast?.let{toDomainCastList(it)},
            crew = model.crew?.let {toDomainCrewList(it)}
        )
    }

    fun toDomainGenre(model: GenreDto): Genre {
        return Genre(
            model.id,
            model.name
        )
    }

    fun toDomainCast(model: CastDto): Cast {
        return Cast(
            model.adult,
            model.gender,
            model.id,
            model.name,
            model.originalName,
            model.profilePath,
            model.character
        )
    }

    fun toDomainCrew(model: CrewDto): Crew {
        return Crew(
            model.adult,
            model.gender,
            model.id,
            model.name,
            model.originalName,
            model.profilePath,
            model.department,
            model.job
        )
    }

    fun toDomainGenreList(list: List<GenreDto>): List<Genre> {
        return list.map {
            toDomainGenre(it)
        }
    }

    fun toDomainCastList(list: List<CastDto>): List<Cast> {
        return list.map {
            toDomainCast(it)
        }
    }

    fun toDomainCrewList(list: List<CrewDto>): List<Crew> {
        return list.map {
            toDomainCrew(it)
        }
    }

    fun toDomainMovieList(initial: List<MovieDto>): List<Movie>{
        return initial.map { mapToDomainModel(it) }
    }

    fun toDomainMovieDetails(initial: MovieDetailsDto): MovieDetails{
        return mapToDomainModel(initial)
    }

    fun toDomainMovieCredits(initial: MovieCreditsDto): MovieCredits{
        return mapToDomainModel(initial)
    }

}