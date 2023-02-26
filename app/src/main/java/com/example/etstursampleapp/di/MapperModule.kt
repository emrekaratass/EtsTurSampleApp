package com.example.etstursampleapp.di

import com.example.etstursampleapp.data.mapper.MovieDomainMapper
import com.example.etstursampleapp.domain.mapper.MovieItemMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providesMovieDomainMapper(): MovieDomainMapper = MovieDomainMapper()

    @Provides
    fun providesMovieItemMapper(): MovieItemMapper = MovieItemMapper()
}