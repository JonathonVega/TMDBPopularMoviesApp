package com.jonathonfvega.tmdbpopularmoviesapp.domain.model

data class MovieDetails(
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val budget: Int? = null,
    val genres: List<Genre>? = listOf(),
    val id: Int? = 0,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val releaseDate: String? = null,
    val revenue: Long? = 0,
    val status: String? = null,
    val title: String? = null
)
