package com.icanerdogan.imdb.data.repository.movie.datasourceImpl

import com.icanerdogan.imdb.data.API.TMDBService
import com.icanerdogan.imdb.data.model.movie.MovieList
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies()
    }
}