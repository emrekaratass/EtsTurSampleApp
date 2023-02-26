package com.example.etstursampleapp.domain.usecase


import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.data.succeeded
import com.example.etstursampleapp.domain.mapper.MovieItemMapper
import com.example.etstursampleapp.domain.repository.MovieRepository
import com.example.etstursampleapp.ui.entity.MovieViewItems
import com.example.etstursampleapp.util.usecase.Params
import com.example.etstursampleapp.util.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository,
    private val mapper: MovieItemMapper
) : UseCase.FlowUseCase<MovieParams, MovieViewItems> {

    override suspend fun execute(params: MovieParams): Flow<Result<MovieViewItems>> {
        return repository.fetchMovies(params).flatMapLatest { result ->
            flow {
                if (result.succeeded) {
                    result as Result.Success
                    val viewItem = mapper.map(result.data)
                    emit(Result.Success(viewItem))
                    return@flow
                }
                result as Result.Error
                emit(Result.Error(result.exception))
            }
        }.catch { throwable ->
            emit(Result.Error(Exception(throwable)))
        }.flowOn(Dispatchers.IO)
    }
}

object MovieParams : Params()
