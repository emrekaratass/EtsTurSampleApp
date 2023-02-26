package com.example.etstursampleapp.domain.entity

import com.example.etstursampleapp.util.entity.DomainItem

data class MovieItem(
    val name: String? = null,
    val posterPath: String? = null,
    val backDropPath: String? = null,
    val description: String? = null,
    val country: String? = null,
    val date: String? = null,
    val voteAverage: Double? = null
) : DomainItem
