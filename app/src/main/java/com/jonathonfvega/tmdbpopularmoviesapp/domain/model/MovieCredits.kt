package com.jonathonfvega.tmdbpopularmoviesapp.domain.model

data class MovieCredits(
    val id: Int? = null,
    val cast: List<Cast>? = listOf(),
    val crew: List<Crew>? = listOf()
)
