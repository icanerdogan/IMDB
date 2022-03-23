package com.icanerdogan.imdb.presentation.dependencyinjection.core

import com.anushka.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.icanerdogan.imdb.data.repository.artist.ArtistRepositoryImpl
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistRemoteDataSource
import com.icanerdogan.imdb.data.repository.movie.MovieRepositoryImpl
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieCacheDataSource
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieLocalDataSource
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieRemoteDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.icanerdogan.imdb.domain.repository.ArtistRepository
import com.icanerdogan.imdb.domain.repository.MovieRepository
import com.icanerdogan.imdb.domain.repository.TVShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TVShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }



}