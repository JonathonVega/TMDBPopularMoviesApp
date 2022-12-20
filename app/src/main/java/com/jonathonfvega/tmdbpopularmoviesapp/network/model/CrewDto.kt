package com.jonathonfvega.tmdbpopularmoviesapp.network.model

import com.google.gson.annotations.SerializedName

data class CrewDto(

    @SerializedName("adult")
    var adult: Boolean? = null,

    @SerializedName("gender")
    var gender: Int? = 0,

    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("original_name")
    var originalName: String? = null,

    @SerializedName("profile_path")
    var profilePath: String? = null,

    @SerializedName("department")
    var department: String? = null,

    @SerializedName("job")
    var job: String? = null,

)
