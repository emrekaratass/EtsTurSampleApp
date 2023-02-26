package com.example.etstursampleapp.util.usecase

import com.example.etstursampleapp.data.Result
import com.example.etstursampleapp.ui.entity.MovieViewItems
import kotlinx.coroutines.flow.Flow

interface UseCase {

    @FunctionalInterface
    interface FlowUseCase<in P, out T> : UseCase where P : Params {
        suspend fun execute(params: P): Flow<Result<MovieViewItems>>
    }
}

abstract class Params