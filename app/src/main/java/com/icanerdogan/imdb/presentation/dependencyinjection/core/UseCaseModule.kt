package com.icanerdogan.imdb.presentation.dependencyinjection.core


import com.icanerdogan.imdb.domain.repository.ArtistRepository
import com.icanerdogan.imdb.domain.repository.MovieRepository
import com.icanerdogan.imdb.domain.repository.TVShowRepository
import com.icanerdogan.imdb.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TVShowRepository):GetTVShowsUseCase{
        return GetTVShowsUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TVShowRepository): UpdateTVShowsUseCase{
        return UpdateTVShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

}