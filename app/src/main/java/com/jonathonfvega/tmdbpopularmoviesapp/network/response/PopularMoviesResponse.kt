package com.jonathonfvega.tmdbpopularmoviesapp.network.response
import com.google.gson.annotations.SerializedName
import com.jonathonfvega.tmdbpopularmoviesapp.network.model.MovieDto

data class PopularMoviesResponse(

    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val results: List<MovieDto>

)
