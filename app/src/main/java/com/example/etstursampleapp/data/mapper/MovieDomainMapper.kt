package com.example.etstursampleapp.data.mapper

import com.example.etstursampleapp.data.entity.MovieResponse
import com.example.etstursampleapp.domain.entity.MovieItem
import com.example.etstursampleapp.domain.entity.MovieItems
import com.example.etstursampleapp.util.mapper.Mapper

class MovieDomainMapper : Mapper<MovieResponse, MovieItems> {

    override suspend fun map(item: MovieResponse): MovieItems {
        val movies: ArrayList<MovieItem> = arrayListOf()
        item.results?.forEach { response ->
            val movie = MovieItem(
                name = response.name,
                posterPath = response.posterPath,
                backDropPath = response.backDropPath,
                description = response.description,
                country = response.countries?.get(0),
                date = response.date,
                voteAverage = response.voteAverage
            )
            movies.add(movie)
        }
        return MovieItems(movies)
    }
}