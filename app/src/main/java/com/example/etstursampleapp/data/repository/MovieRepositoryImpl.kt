package com.example.etstursampleapp.data.repository

import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.data.datasource.MovieRemoteDataSource
import com.example.etstursampleapp.domain.entity.MovieItems
import com.example.etstursampleapp.domain.repository.MovieRepository
import com.example.etstursampleapp.domain.usecase.MovieParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun fetchMovies(params: MovieParams): Flow<Result<MovieItems>> =
        remoteDataSource.fetchMovie(params)
}