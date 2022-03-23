package com.icanerdogan.imdb.data.repository.artist.datasource

import com.icanerdogan.imdb.data.model.artist.Artist

interface  ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}