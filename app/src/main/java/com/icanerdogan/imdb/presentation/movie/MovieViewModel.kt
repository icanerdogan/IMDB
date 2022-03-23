package com.icanerdogan.imdb.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.icanerdogan.imdb.data.model.movie.Movie
import com.icanerdogan.imdb.domain.usecase.GetMoviesUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() : LiveData<List<Movie>?> = liveData {
        val movieList : List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }
    fun updateMovies() : LiveData<List<Movie>?> =  liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}