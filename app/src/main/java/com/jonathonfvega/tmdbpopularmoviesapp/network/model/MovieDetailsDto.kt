package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsDto(

    @SerializedName("adult")
    var adult:Boolean? = null,

    @SerializedName("backdrop_path")
    var backdropPath:String? = null,

    @SerializedName("budget")
    var budget: Int? = 0,

    @SerializedName("genres")
    var genres: List<Genre>? = null,

    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("original_language")
    var originalLanguage: String? = null,

    @SerializedName("original_title")
    var originalTitle: String? = null,

    @SerializedName("overview")
    var overview: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("title")
    var title: String? = null


)
