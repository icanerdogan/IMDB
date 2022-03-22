package com.icanerdogan.imdb.domain.usecase

import com.icanerdogan.imdb.data.model.artist.Artist
import com.icanerdogan.imdb.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = artistRepository.getArtist()
}