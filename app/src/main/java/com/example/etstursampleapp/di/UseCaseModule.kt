package com.example.etstursampleapp.di

import com.example.etstursampleapp.domain.usecase.GetMovieUseCase
import com.example.etstursampleapp.util.usecase.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetMovieUseCase(useCase: GetMovieUseCase): UseCase
}