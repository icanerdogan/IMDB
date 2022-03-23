package com.icanerdogan.imdb.data.repository.artist.datasource

import com.icanerdogan.imdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}