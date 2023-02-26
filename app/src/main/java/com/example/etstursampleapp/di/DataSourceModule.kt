package com.example.etstursampleapp.di

import com.example.etstursampleapp.data.datasource.MovieRemoteDataSource
import com.example.etstursampleapp.data.datasource.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMovieRemoteDataSource(remoteDataSource: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}