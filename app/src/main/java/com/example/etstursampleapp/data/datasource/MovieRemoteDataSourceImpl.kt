package com.example.etstursampleapp.data.datasource

import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.data.mapper.MovieDomainMapper
import com.example.etstursampleapp.data.service.MovieService
import com.example.etstursampleapp.domain.entity.MovieItems
import com.example.etstursampleapp.domain.usecase.MovieParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService,
    private val mapper: MovieDomainMapper
) : MovieRemoteDataSource {

    override suspend fun fetchMovie(params: MovieParams): Flow<Result<MovieItems>> =
        flow<Result<MovieItems>> {
            val response = service.getTvMovies()
            val movies = mapper.map(response)

            emit(Result.Success(movies))
        }.catch { throwable ->
            emit(Result.Error(Exception(throwable)))
        }.flowOn(Dispatchers.IO)
}