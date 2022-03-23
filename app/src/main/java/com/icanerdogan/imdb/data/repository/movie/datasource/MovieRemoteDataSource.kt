package com.icanerdogan.imdb.data.repository.movie.datasource

import com.icanerdogan.imdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}