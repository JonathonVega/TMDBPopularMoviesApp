package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.google.gson.annotations.SerializedName

data class MovieCreditsDto(

    @SerializedName("id")
    var id:Int? = null,

    @SerializedName("cast")
    var cast: List<CastDto>? = null,

    @SerializedName("crew")
    var crew: List<CrewDto>? = null


)
