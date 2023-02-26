package com.example.etstursampleapp.data.service

import com.example.etstursampleapp.data.entity.MovieResponse
import retrofit2.http.GET

interface MovieService {

    @GET("tv/popular")
    suspend fun getTvMovies(): MovieResponse
}
