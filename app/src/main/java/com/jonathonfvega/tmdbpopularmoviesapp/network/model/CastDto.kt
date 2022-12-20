package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.google.gson.annotations.SerializedName

data class CastDto(

    @SerializedName("adult")
    var adult: Boolean? = null,

    @SerializedName("gender")
    var gender:Int? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("original_name")
    var originalName: String? = null,

    @SerializedName("profile_path")
    var profilePath: String? = null,

    @SerializedName("character")
    var character: String? = null,
)
