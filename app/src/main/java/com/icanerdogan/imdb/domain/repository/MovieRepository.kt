package com.icanerdogan.imdb.domain.repository

import com.icanerdogan.imdb.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}