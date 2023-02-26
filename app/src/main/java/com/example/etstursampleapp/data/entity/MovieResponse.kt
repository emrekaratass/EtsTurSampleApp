package com.example.etstursampleapp.data.entity

import com.example.etstursampleapp.util.entity.RemoteDataSourceItem

data class MovieResponse(
    val results: List<Movie>? = null
) : RemoteDataSourceItem