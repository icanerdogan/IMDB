package com.icanerdogan.imdb.data.repository.movie.datasource

import com.icanerdogan.imdb.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}