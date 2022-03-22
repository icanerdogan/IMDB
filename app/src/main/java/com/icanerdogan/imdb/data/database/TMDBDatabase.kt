package com.icanerdogan.imdb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.icanerdogan.imdb.data.model.artist.Artist
import com.icanerdogan.imdb.data.model.movie.Movie
import com.icanerdogan.imdb.data.model.tvshow.TVShow

@Database(
    entities = [Movie::class, TVShow::class, Artist::class],
    version = 1,
    exportSchema = false,

)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun tvDao() : TVShowDao
    abstract fun artistDao() : ArtistDao
}