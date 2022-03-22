package com.icanerdogan.imdb.domain.usecase

import com.icanerdogan.imdb.data.model.movie.Movie
import com.icanerdogan.imdb.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()
}