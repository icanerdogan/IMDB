package com.icanerdogan.imdb.presentation.dependencyinjection.core

import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.icanerdogan.imdb.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieCacheDataSource
import com.icanerdogan.imdb.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource() : MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideTVShowCacheDataSource() : TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataSource() : ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
}