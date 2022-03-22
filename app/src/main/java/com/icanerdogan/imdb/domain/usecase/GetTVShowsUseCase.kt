package com.icanerdogan.imdb.domain.usecase

import com.icanerdogan.imdb.data.model.tvshow.TVShow
import com.icanerdogan.imdb.domain.repository.TVShowRepository

class GetTVShowsUseCase(private val tvShowRepository: TVShowRepository) {
    suspend fun execute() : List<TVShow>? = tvShowRepository.getTVShows()

}