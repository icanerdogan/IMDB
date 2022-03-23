package com.icanerdogan.imdb.data.repository.artist.datasourceImpl

import com.icanerdogan.imdb.data.database.ArtistDao
import com.icanerdogan.imdb.data.database.MovieDao
import com.icanerdogan.imdb.data.model.artist.Artist
import com.icanerdogan.imdb.data.model.movie.Movie
import com.icanerdogan.imdb.data.repository.artist.datasource.ArtistLocalDataSource
import com.icanerdogan.imdb.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {

    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}