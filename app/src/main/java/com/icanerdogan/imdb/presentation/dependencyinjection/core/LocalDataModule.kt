package com.icanerdogan.imdb.presentation.dependencyinjection.core

import com.icanerdogan.imdb.data.database.ArtistDao
import com.icanerdogan.imdb.data.database.MovieDao
import com.icanerdogan.imdb.data.database.TVShowDao
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.icanerdogan.imdb.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieLocalDataSource
import com.icanerdogan.imdb.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.icanerdogan.imdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.icanerdogan.imdb.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// data > repository >  datasourceImpl içine baktığımızda fonksiyonlar DAO alıyor bizde onu vermemiz gerekiyor!
// Fonskiyonlar Impl'nin kullandığı interface dosyasını döndürüyor!
@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTVShowLocalDataSource(tvShowDao: TVShowDao) : TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }
}