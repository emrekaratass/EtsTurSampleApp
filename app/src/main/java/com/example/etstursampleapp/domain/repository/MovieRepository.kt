package com.example.etstursampleapp.domain.repository

import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.domain.entity.MovieItems
import com.example.etstursampleapp.domain.usecase.MovieParams
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchMovies(params: MovieParams): Flow<Result<MovieItems>>
}