package com.icanerdogan.imdb.presentation.dependencyinjection.core

import android.content.Context
import androidx.room.Room
import com.icanerdogan.imdb.data.database.ArtistDao
import com.icanerdogan.imdb.data.database.MovieDao
import com.icanerdogan.imdb.data.database.TMDBDatabase
import com.icanerdogan.imdb.data.database.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideMovieDatabase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideTVDao(tmdbDatabase: TMDBDatabase) : TVShowDao{
        return tmdbDatabase.tvDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }
}