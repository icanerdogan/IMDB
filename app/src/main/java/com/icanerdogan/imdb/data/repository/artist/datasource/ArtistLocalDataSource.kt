package com.icanerdogan.imdb.data.repository.artist.datasource

import com.icanerdogan.imdb.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistToDB(artists : List<Artist>)
    suspend fun clearAll()
}