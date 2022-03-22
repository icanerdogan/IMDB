package com.icanerdogan.imdb.domain.repository

import com.icanerdogan.imdb.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShows() : List<TVShow>
    suspend fun updateTVShows() : List<TVShow>
}