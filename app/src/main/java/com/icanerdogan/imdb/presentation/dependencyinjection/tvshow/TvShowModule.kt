package com.icanerdogan.imdb.presentation.dependencyinjection.tvshow

import com.icanerdogan.imdb.domain.usecase.GetTVShowsUseCase
import com.icanerdogan.imdb.domain.usecase.UpdateTVShowsUseCase
import com.icanerdogan.imdb.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTVShowsUseCase,
        updateTvShowsUseCase: UpdateTVShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}