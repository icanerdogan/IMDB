package com.icanerdogan.imdb.presentation.dependencyinjection.core

import com.icanerdogan.imdb.data.API.TMDBService
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.icanerdogan.imdb.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.icanerdogan.imdb.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.icanerdogan.imdb.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideTVRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(tmdbService)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService)
    }
}