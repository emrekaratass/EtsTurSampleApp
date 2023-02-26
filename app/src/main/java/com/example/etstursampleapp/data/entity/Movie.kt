package com.example.etstursampleapp.data.entity

import com.example.etstursampleapp.util.entity.RemoteDataSourceItem
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("backdrop_path")
    val backDropPath: String? = null,
    @SerializedName("overview")
    val description: String? = null,
    @SerializedName("origin_country")
    val countries: List<String>? = null,
    @SerializedName("first_air_date")
    val date: String? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null
) : RemoteDataSourceItem
