package com.example.etstursampleapp.data.datasource

import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.domain.entity.MovieItems
import com.example.etstursampleapp.domain.usecase.MovieParams
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    suspend fun fetchMovie(params: MovieParams): Flow<Result<MovieItems>>
}