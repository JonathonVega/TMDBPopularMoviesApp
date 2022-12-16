package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.google.gson.annotations.SerializedName

data class MovieDto(

    @SerializedName("poster_path")
    var posterPath:String? = null,

    @SerializedName("adult")
    var adult:Boolean? = null,

    @SerializedName("overview")
    var overview:String? = null,

    @SerializedName("release_date")
    var releaseDate: String? = null,

    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null,

    @SerializedName("id")
    var movieId: Int? = 0,

    @SerializedName("original_title")
    var originalTitle: String? = null,

    @SerializedName("original_language")
    var originalLanguage: String? = null,

    @SerializedName("title")
    var title:String? = null,

)
