package com.example.etstursampleapp.domain.entity

import com.example.etstursampleapp.util.entity.DomainItem

data class MovieItems(
    val movies: List<MovieItem>
) : DomainItem