package com.icanerdogan.imdb.presentation.dependencyinjection.movie


import com.icanerdogan.imdb.domain.usecase.GetMoviesUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateMoviesUseCase
import com.icanerdogan.imdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}