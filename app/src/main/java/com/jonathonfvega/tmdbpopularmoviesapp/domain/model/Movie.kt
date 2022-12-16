package com.jonathonfvega.tmdbpopularmoviesapp.domain.model

data class Movie(
    val posterPath: String? = null,
    val adult: Boolean? = null,
    val overview:String? = null,
    val releaseDate:String? = null,
    val genreIds: List<Int>? = listOf(),
    val id: Int? = 0,
    val originalTitle: String? = null,
    val originalLanguage:String? = null,
    val title:String? = null,
)
