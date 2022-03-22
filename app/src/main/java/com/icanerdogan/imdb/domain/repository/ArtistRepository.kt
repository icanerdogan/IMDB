package com.icanerdogan.imdb.domain.repository

import com.icanerdogan.imdb.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist() : List<Artist>?
    suspend fun updateArtist() : List<Artist>?
}