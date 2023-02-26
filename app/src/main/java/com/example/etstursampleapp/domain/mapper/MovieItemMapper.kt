package com.example.etstursampleapp.domain.mapper

import com.example.etstursampleapp.domain.entity.MovieItems
import com.example.etstursampleapp.ui.entity.MovieViewItem
import com.example.etstursampleapp.ui.entity.MovieViewItems
import com.example.etstursampleapp.util.extension.ignoreNull
import com.example.etstursampleapp.util.mapper.Mapper

class MovieItemMapper : Mapper<MovieItems, MovieViewItems> {

    override suspend fun map(item: MovieItems): MovieViewItems {
        val movies: ArrayList<MovieViewItem> = arrayListOf()
        item.movies.forEach { response ->
            val movieItem = MovieViewItem(
                name = response.name.ignoreNull(),
                posterPath = response.posterPath.ignoreNull(),
                voteAverage = response.voteAverage.ignoreNull(),
                backDropPath = response.backDropPath.ignoreNull(),
                description = response.description.ignoreNull(),
                country = response.country.ignoreNull(),
                date = response.date.ignoreNull()
            )
            movies.add(movieItem)
        }
        return MovieViewItems(movies)
    }
}