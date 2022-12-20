package com.jonathonfvega.tmdbpopularmoviesapp.domain.model

data class Cast(
    val adult: Boolean? = null,
    val gender: Int? = 0,
    val id: Int? = 0,
    val name: String? = null,
    val originalName: String? = null,
    val profilePath: String? = null,
    val character: String? = null,
)
